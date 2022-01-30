package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.TopicCategoryEntity;

public interface TopicCategoryRepository extends JpaRepository<TopicCategoryEntity, Long> {
    TopicCategoryEntity findByName(String categoryName);
}