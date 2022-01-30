package tr.com.r10.portal.converter;

import org.springframework.stereotype.Component;
import tr.com.r10.portal.dto.TopicCategory;
import tr.com.r10.portal.model.TopicCategoryEntity;

import java.util.Objects;

@Component
public class TopicCategoryConverter implements Converter<TopicCategoryEntity, TopicCategory> {
    @Override
    public TopicCategoryEntity convertToEntity(TopicCategory topicCategory) {
        if (Objects.isNull(topicCategory)) {
            return null;
        }
        TopicCategoryEntity topicCategoryEntity = new TopicCategoryEntity();
        topicCategoryEntity.setName(topicCategory.getName());
        topicCategoryEntity.setDescription(topicCategory.getDescription());
        topicCategoryEntity.setId(topicCategory.getId());
        topicCategoryEntity.setCreatedDate(topicCategory.getCreatedDate());
        topicCategoryEntity.setUpdatedDate(topicCategory.getUpdatedDate());
        return topicCategoryEntity;
    }

    @Override
    public TopicCategory convertToDTO(TopicCategoryEntity topicCategoryEntity) {
        if (Objects.isNull(topicCategoryEntity)) {
            return null;
        }
        TopicCategory topicCategory = new TopicCategory();
        topicCategory.setName(topicCategoryEntity.getName());
        topicCategory.setDescription(topicCategoryEntity.getDescription());
        topicCategory.setId(topicCategoryEntity.getId());
        topicCategory.setCreatedDate(topicCategoryEntity.getCreatedDate());
        topicCategory.setUpdatedDate(topicCategoryEntity.getUpdatedDate());
        return topicCategory;
    }
}