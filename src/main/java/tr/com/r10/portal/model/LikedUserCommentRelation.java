package tr.com.r10.portal.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LIKED_USER_COMMENT")
public class LikedUserCommentRelation extends BaseEntity {
    @ManyToOne
    private CommentEntity comment;
    @ManyToOne
    private UserEntity likedUser;

    public UserEntity getLikedUser() {
        return likedUser;
    }

    public void setLikedUser(UserEntity likedUser) {
        this.likedUser = likedUser;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LikedUserCommentRelation{" +
                "comment=" + comment +
                ", likedUser=" + likedUser +
                '}';
    }
}