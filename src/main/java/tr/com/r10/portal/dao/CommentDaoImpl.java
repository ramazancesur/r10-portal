package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.CommentDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.CommentEntity;
import tr.com.r10.portal.repository.CommentRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    private CommentRepository commentRepository;

    @Override
    public CommentEntity save(CommentEntity data) {
        return commentRepository.save(data);
    }

    @Override
    public CommentEntity get(Long id) {
        return commentRepository.getById(id);
    }

    @Override
    public List<CommentEntity> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<CommentEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return commentRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}