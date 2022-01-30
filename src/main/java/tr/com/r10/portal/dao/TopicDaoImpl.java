package tr.com.r10.portal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tr.com.r10.portal.dao.interfaces.TopicDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.model.TopicEntity;
import tr.com.r10.portal.repository.TopicRepository;
import tr.com.r10.portal.util.PageUtil;

import java.util.List;

@Repository
public class TopicDaoImpl implements TopicDao {
    private TopicRepository topicRepository;

    @Override
    public TopicEntity save(TopicEntity data) {
        return topicRepository.save(data);
    }

    @Override
    public TopicEntity get(Long id) {
        return topicRepository.getById(id);
    }

    @Override
    public List<TopicEntity> getAll() {
        return topicRepository.findAll();
    }

    @Override
    public List<TopicEntity> getAllDataWithPagination(PageablePortal pageablePortal) {
        Pageable pageable = PageUtil.getPageableData(pageablePortal);
        return topicRepository.findAll(pageable).getContent();
    }

    @Override
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }

    @Autowired
    public void setTopicRepository(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
}