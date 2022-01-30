package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.UserDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.UserEntity;
import tr.com.r10.portal.repository.UserRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private UserRepository userRepository;

    @Override
    public UserEntity save(UserEntity data) {
        return userRepository.save(data);
    }

    @Override
    public UserEntity get(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}