package tr.com.r10.portal.controller.interfaces;

import org.springframework.web.bind.annotation.*;
import tr.com.r10.portal.dto.Comment;
import tr.com.r10.portal.dto.PageablePortal;

import java.util.List;

@RequestMapping("/comment")
public interface CommentController {
    @GetMapping("/all")
    List<Comment> getAllTopic();

    @PostMapping("/pageWithData")
    List<Comment> getAllTopicPagination(@RequestBody PageablePortal pageablePortal);

    @PostMapping("/save")
    Comment saveTopic(@RequestBody Comment comment);

    @PostMapping("/update")
    Comment updateTopic(@RequestBody Comment comment);

    @DeleteMapping("/delete")
    Comment deleteTopic(@RequestParam(value = "id") Long id);
}