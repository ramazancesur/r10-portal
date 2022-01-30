package tr.com.r10.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tr.com.r10.portal.controller.interfaces.CommentController;
import tr.com.r10.portal.dto.Comment;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.exceptions.NotFoundException;
import tr.com.r10.portal.service.interfaces.CommentService;

import java.util.List;
import java.util.Objects;

@RestController
public class CommentControllerImpl implements CommentController {
    private CommentService commentService;

    @Override
    public List<Comment> getAllTopic() {
        return commentService.getAll();
    }

    @Override
    public List<Comment> getAllTopicPagination(PageablePortal pageablePortal) {
        return commentService.getAllDataWithPagination(pageablePortal);
    }

    @Override
    public Comment saveTopic(Comment comment) {
        return commentService.save(comment);
    }

    @Override
    public Comment updateTopic(Comment comment) {
        return commentService.save(comment);
    }

    @Override
    public Comment deleteTopic(Long id) {
        Comment comment = commentService.get(id);
        if (Objects.isNull(comment)) {
            throw new NotFoundException("Comment not found for comment id is " + id);
        }
        commentService.deleteById(id);
        return comment;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
}