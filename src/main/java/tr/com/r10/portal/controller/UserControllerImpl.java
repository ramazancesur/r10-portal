package tr.com.r10.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tr.com.r10.portal.controller.interfaces.UserController;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.dto.User;
import tr.com.r10.portal.exceptions.NotFoundException;
import tr.com.r10.portal.service.interfaces.UserService;

import java.util.List;
import java.util.Objects;

@RestController
public class UserControllerImpl implements UserController {
    private UserService userService;
    @Override
    public List<User> getAllTopic() {
        return userService.getAll();
    }

    @Override
    public List<User> getAllTopicPagination(PageablePortal pageablePortal) {
        return userService.getAllDataWithPagination(pageablePortal);
    }

    @Override
    public User saveTopic(User user) {
        return userService.save(user);
    }

    @Override
    public User updateTopic(User user) {
        return userService.save(user);
    }

    @Override
    public User deleteTopic(Long id) {
        User removedUser= userService.get(id);
        if(Objects.isNull(removedUser)){
            throw new NotFoundException("user not found for ID is "+ id);
        }
        userService.deleteById(id);
        return removedUser;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}