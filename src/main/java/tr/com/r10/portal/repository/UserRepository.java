package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String userName);
}