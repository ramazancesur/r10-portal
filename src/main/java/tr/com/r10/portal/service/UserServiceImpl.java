package tr.com.r10.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.r10.portal.converter.UserConverter;
import tr.com.r10.portal.dao.interfaces.UserDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.dto.User;
import tr.com.r10.portal.model.UserEntity;
import tr.com.r10.portal.service.interfaces.UserService;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserConverter userConverter;

    @Override
    public User save(User user) {
        UserEntity currentUser = userConverter.convertToEntity(user);
        if (Objects.isNull(currentUser)) {
            return null;
        }
        return userConverter.convertToDTO(userDao.save(currentUser));
    }

    @Override
    public User get(Long id) {
        return userConverter.convertToDTO(userDao.get(id));
    }

    @Override
    public List<User> getAll() {
        return userConverter.convertToDTOList(userDao.getAll());
    }

    @Override
    public List<User> getAllDataWithPagination(PageablePortal pageablePortal) {
        return userConverter.convertToDTOList(userDao.getAllDataWithPagination(pageablePortal));
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }
}