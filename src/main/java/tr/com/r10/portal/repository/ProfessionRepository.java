package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.ProfessionEntity;

public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Long> {
    ProfessionEntity findAllByName(String professionName);
}