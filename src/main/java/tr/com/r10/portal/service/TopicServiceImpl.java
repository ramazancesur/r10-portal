package tr.com.r10.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.r10.portal.converter.TopicConverter;
import tr.com.r10.portal.dao.interfaces.TopicDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.dto.Topic;
import tr.com.r10.portal.model.TopicEntity;
import tr.com.r10.portal.service.interfaces.TopicService;

import java.util.List;
import java.util.Objects;

@Service
public class TopicServiceImpl implements TopicService {
    private TopicConverter topicConverter;
    private TopicDao topicDao;

    @Override
    public Topic save(Topic topic) {
        TopicEntity topicEntity = topicConverter.convertToEntity(topic);
        if (Objects.isNull(topicEntity)) {
            return null;
        }
        topicEntity = topicDao.save(topicEntity);
        return topicConverter.convertToDTO(topicEntity);
    }

    @Override
    public Topic get(Long id) {
        return topicConverter.convertToDTO(topicDao.get(id));
    }

    @Override
    public List<Topic> getAll() {
        return topicConverter.convertToDTOList(topicDao.getAll());
    }

    @Override
    public List<Topic> getAllDataWithPagination(PageablePortal pageablePortal) {
        return topicConverter.convertToDTOList(topicDao.getAllDataWithPagination(pageablePortal));
    }

    @Override
    public void deleteById(Long id) {
        topicDao.deleteById(id);
    }

    @Autowired
    public void setTopicConverter(TopicConverter topicConverter) {
        this.topicConverter = topicConverter;
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }
}