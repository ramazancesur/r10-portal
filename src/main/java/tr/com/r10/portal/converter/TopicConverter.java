package tr.com.r10.portal.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.r10.portal.dto.Topic;
import tr.com.r10.portal.model.TopicEntity;
import tr.com.r10.portal.repository.TopicCategoryRepository;

import java.util.Objects;

@Component
public class TopicConverter implements Converter<TopicEntity, Topic> {
    private TopicCategoryRepository categoryRepository;

    @Override
    public TopicEntity convertToEntity(Topic topic) {
        if (Objects.isNull(topic)) {
            return null;
        }
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setId(topic.getTopicId());
        topicEntity.setCreatedDate(topic.getCreatedDate());
        topicEntity.setUpdatedDate(topic.getUpdatedDate());
        topicEntity.setHeader(topic.getHeader());
        topicEntity.setAnswerCount(topic.getAnswerCount());
        topicEntity.setViewedCount(topic.getViewedCount());
        topicEntity.setTopicType(topic.getTopicType());
        if (Objects.nonNull(topic.getTopicCategory())) {
            topicEntity.setTopicCategory(categoryRepository.findByName(topic.getTopicCategory()));
        }
        return topicEntity;
    }

    @Override
    public Topic convertToDTO(TopicEntity topicEntity) {
        if (Objects.isNull(topicEntity)) {
            return null;
        }
        Topic topic = new Topic();
        topic.setTopicId(topicEntity.getId());
        topic.setCreatedDate(topicEntity.getCreatedDate());
        topic.setUpdatedDate(topicEntity.getUpdatedDate());
        topic.setHeader(topicEntity.getHeader());
        topic.setAnswerCount(topicEntity.getAnswerCount());
        topic.setViewedCount(topicEntity.getViewedCount());
        topic.setTopicType(topicEntity.getTopicType());
        if (Objects.nonNull(topicEntity.getTopicCategory())) {
            topic.setTopicCategory(topicEntity.getTopicCategory().getName());
        }
        return topic;
    }

    @Autowired
    public void setCategoryRepository(TopicCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}