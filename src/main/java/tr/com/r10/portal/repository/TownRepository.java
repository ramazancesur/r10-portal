package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.TownEntity;

public interface TownRepository extends JpaRepository<TownEntity, Long> {
    TownEntity findByName(String townName);
}