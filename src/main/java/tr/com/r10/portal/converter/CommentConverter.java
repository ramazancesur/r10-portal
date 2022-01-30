package tr.com.r10.portal.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.r10.portal.dto.Comment;
import tr.com.r10.portal.dto.FileContent;
import tr.com.r10.portal.dto.User;
import tr.com.r10.portal.model.CommentEntity;
import tr.com.r10.portal.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CommentConverter implements Converter<CommentEntity, Comment> {
    private UserRepository userRepository;
    private FileContentConverter fileContentConverter;
    private UserConverter userConverter;

    @Override
    public CommentEntity convertToEntity(Comment comment) {
        if (Objects.isNull(comment)) {
            return null;
        }
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(comment.getCommentID());
        commentEntity.setLikeCount(comment.getLikeCount());
        commentEntity.setDailyLikeCount(comment.getDailyLikeCount());
        commentEntity.setCreatedDate(comment.getCreatedDate());
        commentEntity.setUpdatedDate(comment.getUpdatedDate());
        commentEntity.setUser(userRepository.findByUsername(comment.getUserCommented()));
        FileContent fileContent = comment.getFileContent();
        // todo many files adding to comment
        commentEntity.setFiles(Arrays.asList(fileContentConverter.convertToEntity(fileContent)));
        return commentEntity;
    }

    @Override
    public Comment convertToDTO(CommentEntity commentEntity) {
        if (Objects.isNull(commentEntity)) {
            return null;
        }
        Comment comment = new Comment();
        comment.setCommentID(commentEntity.getId());
        comment.setLikeCount(commentEntity.getLikeCount());
        comment.setDailyLikeCount(commentEntity.getDailyLikeCount());
        comment.setCreatedDate(commentEntity.getCreatedDate());
        comment.setUpdatedDate(commentEntity.getUpdatedDate());
        User user = userConverter.convertToDTO(commentEntity.getUser());
        if (Objects.nonNull(user)) {
            comment.setUserCommented(user.getUsername());
        }
        List<FileContent> fileContentList = fileContentConverter.convertToDTOList(commentEntity.getFiles());
        // todo same as line 34 state
        if (fileContentList.size() != 0) {
            comment.setFileContent(fileContentList.get(0));
        }
        return comment;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setFileContentConverter(FileContentConverter fileContentConverter) {
        this.fileContentConverter = fileContentConverter;
    }

    @Autowired
    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }
}