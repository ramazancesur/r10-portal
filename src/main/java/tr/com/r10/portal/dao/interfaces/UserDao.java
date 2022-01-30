package tr.com.r10.portal.dao.interfaces;

import tr.com.r10.portal.model.UserEntity;

public interface UserDao extends GenericDao<UserEntity> {
    UserEntity findByUsername(String username);
}