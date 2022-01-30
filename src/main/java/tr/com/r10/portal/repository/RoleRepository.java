package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByRoleName(String roleName);
}