package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.TopicEntity;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
}