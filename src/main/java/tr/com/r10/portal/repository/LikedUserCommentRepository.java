package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.LikedUserCommentRelation;

public interface LikedUserCommentRepository extends JpaRepository<LikedUserCommentRelation, Long> {
}