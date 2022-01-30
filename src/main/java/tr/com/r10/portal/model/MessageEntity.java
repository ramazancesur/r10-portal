package tr.com.r10.portal.model;

import tr.com.r10.portal.enums.MessageStatusType;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGE")
public class MessageEntity extends BaseEntity {
    @Column
    private String messageContent;
    @ManyToOne
    private FileEntity sendingFile;
    @ManyToOne
    private UserEntity postingUser;
    @ManyToOne
    private UserEntity receiverUser;
    @Enumerated(EnumType.STRING)
    @Column
    private MessageStatusType statusType;

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public FileEntity getSendingFile() {
        return sendingFile;
    }

    public void setSendingFile(FileEntity sendingFile) {
        this.sendingFile = sendingFile;
    }

    public UserEntity getPostingUser() {
        return postingUser;
    }

    public void setPostingUser(UserEntity postingUser) {
        this.postingUser = postingUser;
    }

    public UserEntity getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(UserEntity receiverUser) {
        this.receiverUser = receiverUser;
    }

    public MessageStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(MessageStatusType statusType) {
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "messageContent='" + messageContent + '\'' +
                ", sendingFile=" + sendingFile +
                ", postingUser=" + postingUser +
                ", receiverUser=" + receiverUser +
                ", statusType=" + statusType +
                '}';
    }
}