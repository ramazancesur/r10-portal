package tr.com.r10.portal.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COMMENT")
public class CommentEntity extends BaseEntity {
    @Column
    private String content;
    @Column
    private int likeCount;
    @Column
    private int dailyLikeCount;

    @OneToMany(fetch = FetchType.LAZY)
    private List<FileEntity> files = new ArrayList();

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDailyLikeCount() {
        return dailyLikeCount;
    }

    public void setDailyLikeCount(int dailyLikeCount) {
        this.dailyLikeCount = dailyLikeCount;
    }

    public List<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(List<FileEntity> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "content='" + content + '\'' +
                ", likeCount=" + likeCount +
                ", dailyLikeCount=" + dailyLikeCount +
                ", files=" + files +
                ", user=" + user +
                '}';
    }
}