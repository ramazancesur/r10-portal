package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.TopicCategoryDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.TopicCategoryEntity;
import tr.com.r10.portal.repository.TopicCategoryRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class TopicCategoryDaoImpl implements TopicCategoryDao {
    private TopicCategoryRepository topicCategoryRepository;

    @Override
    public TopicCategoryEntity save(TopicCategoryEntity data) {
        return topicCategoryRepository.save(data);
    }

    @Override
    public TopicCategoryEntity get(Long id) {
        return topicCategoryRepository.getById(id);
    }

    @Override
    public List<TopicCategoryEntity> getAll() {
        return topicCategoryRepository.findAll();
    }

    @Override
    public List<TopicCategoryEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return topicCategoryRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        topicCategoryRepository.deleteById(id);
    }

    @Autowired
    public void setTopicCategoryRepository(TopicCategoryRepository topicCategoryRepository) {
        this.topicCategoryRepository = topicCategoryRepository;
    }
}