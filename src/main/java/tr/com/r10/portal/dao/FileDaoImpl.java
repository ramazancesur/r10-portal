package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.FileDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.FileEntity;
import tr.com.r10.portal.repository.FileRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class FileDaoImpl implements FileDao {
    private FileRepository fileRepository;

    @Override
    public FileEntity save(FileEntity data) {
        return fileRepository.save(data);
    }

    @Override
    public FileEntity get(Long id) {
        return fileRepository.getById(id);
    }

    @Override
    public List<FileEntity> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public List<FileEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return fileRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        fileRepository.deleteById(id);
    }

    @Autowired
    public void setFileRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
}