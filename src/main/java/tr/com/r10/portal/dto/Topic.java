package tr.com.r10.portal.dto;

import tr.com.r10.portal.enums.TopicType;

public class Topic extends BaseDTO {
    private Long topicId;
    private String header;
    private String topicCategory;
    private String lastComment;
    private int answerCount;
    private int viewedCount;
    private TopicType topicType;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
    }

    public String getLastComment() {
        return lastComment;
    }

    public void setLastComment(String lastComment) {
        this.lastComment = lastComment;
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

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public TopicType getTopicType() {
        return topicType;
    }

    public void setTopicType(TopicType topicType) {
        this.topicType = topicType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;

        Topic topic = (Topic) o;

        if (topicId != null ? !topicId.equals(topic.topicId) : topic.topicId != null) return false;
        return header != null ? header.equals(topic.header) : topic.header == null;
    }

    @Override
    public int hashCode() {
        int result = topicId != null ? topicId.hashCode() : 0;
        result = 31 * result + (header != null ? header.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", header='" + header + '\'' +
                ", topicCategory='" + topicCategory + '\'' +
                ", lastComment='" + lastComment + '\'' +
                ", answerCount=" + answerCount +
                ", viewedCount=" + viewedCount +
                ", topicType=" + topicType +
                '}';
    }


}