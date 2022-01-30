package tr.com.r10.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.r10.portal.converter.TopicCategoryConverter;
import tr.com.r10.portal.dao.interfaces.TopicCategoryDao;
import tr.com.r10.portal.dto.PageablePortal;
import tr.com.r10.portal.dto.TopicCategory;
import tr.com.r10.portal.model.TopicCategoryEntity;
import tr.com.r10.portal.service.interfaces.TopicCategoryService;

import java.util.List;
import java.util.Objects;

@Service
public class TopicCategoryServiceImpl implements TopicCategoryService {
    private TopicCategoryConverter topicCategoryConverter;
    private TopicCategoryDao topicCategoryDao;

    @Override
    public TopicCategory save(TopicCategory topicCategory) {
        TopicCategoryEntity categoryEntity = topicCategoryConverter.convertToEntity(topicCategory);
        if (Objects.isNull(topicCategory)) {
            return null;
        }
        categoryEntity = topicCategoryDao.save(categoryEntity);
        return topicCategoryConverter.convertToDTO(categoryEntity);
    }

    @Override
    public TopicCategory get(Long id) {
        return topicCategoryConverter.convertToDTO(topicCategoryDao.get(id));
    }

    @Override
    public List<TopicCategory> getAll() {
        return topicCategoryConverter.convertToDTOList(topicCategoryDao.getAll());
    }

    @Override
    public List<TopicCategory> getAllDataWithPagination(PageablePortal pageablePortal) {
        return topicCategoryConverter.convertToDTOList(topicCategoryDao.getAllDataWithPagination(pageablePortal));
    }

    @Override
    public void deleteById(Long id) {
        topicCategoryDao.deleteById(id);
    }

    @Autowired
    public void setTopicCategoryConverter(TopicCategoryConverter topicCategoryConverter) {
        this.topicCategoryConverter = topicCategoryConverter;
    }

    @Autowired
    public void setTopicCategoryDao(TopicCategoryDao topicCategoryDao) {
        this.topicCategoryDao = topicCategoryDao;
    }
}