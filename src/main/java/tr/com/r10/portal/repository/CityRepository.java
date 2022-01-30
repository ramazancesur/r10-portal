package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    CityEntity findByName(String cityName);
}