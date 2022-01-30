package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.TownDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.TownEntity;
import tr.com.r10.portal.repository.TownRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class TownDaoImpl implements TownDao {
    private TownRepository townRepository;

    @Override
    public TownEntity save(TownEntity data) {
        return townRepository.save(data);
    }

    @Override
    public TownEntity get(Long id) {
        return townRepository.getById(id);
    }

    @Override
    public List<TownEntity> getAll() {
        return townRepository.findAll();
    }

    @Override
    public List<TownEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return townRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        townRepository.deleteById(id);
    }

    @Autowired
    public void setTownRepository(TownRepository townRepository) {
        this.townRepository = townRepository;
    }
}