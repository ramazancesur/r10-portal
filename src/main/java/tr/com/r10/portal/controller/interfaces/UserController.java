package tr.com.r10.portal.controller.interfaces;

import org.springframework.web.bind.annotation.*;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.dto.User;

import java.util.List;

@RequestMapping("/user")
public interface UserController {
    @GetMapping("/all")
    List<User> getAllTopic();

    @PostMapping("/pageWithData")
    List<User> getAllTopicPagination(@RequestBody PageablePortal pageablePortal);

    @PostMapping("/save")
    User saveTopic(@RequestBody User user);

    @PostMapping("/update")
    User updateTopic(@RequestBody User user);

    @DeleteMapping("/delete")
    User deleteTopic(@RequestParam(value = "id") Long id);
}