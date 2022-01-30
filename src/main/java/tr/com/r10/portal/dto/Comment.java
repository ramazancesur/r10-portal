package tr.com.r10.portal.dto;

public class Comment extends BaseDTO {
    private Long commentID;
    private String content;
    private FileContent fileContent;
    private String userCommented;
    private int likeCount;
    private int dailyLikeCount;

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public int getDailyLikeCount() {
        return dailyLikeCount;
    }

    public void setDailyLikeCount(int dailyLikeCount) {
        this.dailyLikeCount = dailyLikeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FileContent getFileContent() {
        return fileContent;
    }

    public void setFileContent(FileContent fileContent) {
        this.fileContent = fileContent;
    }

    public String getUserCommented() {
        return userCommented;
    }

    public void setUserCommented(String userCommented) {
        this.userCommented = userCommented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        return commentID != null ? commentID.equals(comment.commentID) : comment.commentID == null;
    }

    @Override
    public int hashCode() {
        return commentID != null ? commentID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", content='" + content + '\'' +
                ", fileContent='" + fileContent + '\'' +
                ", userCommented='" + userCommented + '\'' +
                '}';
    }
}