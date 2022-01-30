package tr.com.r10.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.r10.portal.converter.CommentConverter;
import tr.com.r10.portal.dao.interfaces.CommentDao;
import tr.com.r10.portal.dto.Comment;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.CommentEntity;
import tr.com.r10.portal.service.interfaces.CommentService;

import java.util.List;
import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentDao commentDao;
    private CommentConverter commentConverter;

    @Override
    public Comment save(Comment comment) {
        CommentEntity commentEntity = commentConverter.convertToEntity(comment);
        if (Objects.isNull(commentEntity)) {
            return null;
        }
        commentEntity = commentDao.save(commentEntity);
        return commentConverter.convertToDTO(commentEntity);
    }

    @Override
    public Comment get(Long id) {
        return commentConverter.convertToDTO(commentDao.get(id));
    }

    @Override
    public List<Comment> getAll() {
        return commentConverter.convertToDTOList(commentDao.getAll());
    }

    @Override
    public List<Comment> getAllDataWithPagination(PageablePortal pageablePortal) {
        return commentConverter.convertToDTOList(commentDao.getAllDataWithPagination(pageablePortal));
    }

    @Override
    public void deleteById(Long id) {
        commentDao.deleteById(id);
    }

    @Autowired
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Autowired
    public void setCommentConverter(CommentConverter commentConverter) {
        this.commentConverter = commentConverter;
    }
}