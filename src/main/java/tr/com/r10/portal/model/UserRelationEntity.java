package tr.com.r10.portal.model;

import tr.com.r10.portal.enums.UserRelationType;

import javax.persistence.*;

@Entity
@Table(name = "USER_FRIENDSHIP")
public class UserRelationEntity extends BaseEntity {
    @ManyToOne
    private UserEntity mainUser;
    @ManyToOne
    private UserEntity sendingUser;
    @Enumerated(EnumType.STRING)
    @Column
    private UserRelationType relationType;

    public UserEntity getMainUser() {
        return mainUser;
    }

    public void setMainUser(UserEntity mainUser) {
        this.mainUser = mainUser;
    }

    public UserEntity getSendingUser() {
        return sendingUser;
    }

    public void setSendingUser(UserEntity sendingUser) {
        this.sendingUser = sendingUser;
    }

    public UserRelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(UserRelationType relationType) {
        this.relationType = relationType;
    }

    @Override
    public String toString() {
        return "UserRelationEntity{" +
                "mainUser=" + mainUser +
                ", sendingUser=" + sendingUser +
                ", relationType=" + relationType +
                '}';
    }
}
