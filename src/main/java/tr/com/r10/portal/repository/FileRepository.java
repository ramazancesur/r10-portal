package tr.com.r10.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.r10.portal.model.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}