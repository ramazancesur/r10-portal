package tr.com.r10.portal.model;

import tr.com.r10.portal.enums.TopicType;

import javax.persistence.*;

@Entity
@Table(name = "TOPIC")
public class TopicEntity extends BaseEntity {
    @Column
    private String header;
    @Column
    private int answerCount;
    @Column
    private int viewedCount;
    @Enumerated(EnumType.STRING)
    @Column
    private TopicType topicType;
    @ManyToOne
    private TopicCategoryEntity topicCategoryEntity;


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getViewedCount() {
        return viewedCount;
    }

    public void setViewedCount(int viewedCount) {
        this.viewedCount = viewedCount;
    }

    public TopicCategoryEntity getTopicCategory() {
        return topicCategoryEntity;
    }

    public void setTopicCategory(TopicCategoryEntity topicCategoryEntity) {
        this.topicCategoryEntity = topicCategoryEntity;
    }

    public TopicType getTopicType() {
        return topicType;
    }

    public void setTopicType(TopicType topicType) {
        this.topicType = topicType;
    }

    public TopicCategoryEntity getTopicCategoryEntity() {
        return topicCategoryEntity;
    }

    public void setTopicCategoryEntity(TopicCategoryEntity topicCategoryEntity) {
        this.topicCategoryEntity = topicCategoryEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopicEntity)) return false;

        TopicEntity that = (TopicEntity) o;

        return header != null ? header.equals(that.header) : that.header == null;
    }

    @Override
    public int hashCode() {
        return header != null ? header.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TopicEntity{" +
                "header='" + header + '\'' +
                ", answerCount=" + answerCount +
                ", viewedCount=" + viewedCount +
                ", topicType=" + topicType +
                ", topicCategoryEntity=" + topicCategoryEntity +
                '}';
    }
}