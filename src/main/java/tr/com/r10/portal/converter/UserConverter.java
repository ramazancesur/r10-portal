package tr.com.r10.portal.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.r10.portal.dto.Comment;
import tr.com.r10.portal.dto.User;
import tr.com.r10.portal.model.CommentEntity;
import tr.com.r10.portal.model.ProfessionEntity;
import tr.com.r10.portal.model.RoleEntity;
import tr.com.r10.portal.model.UserEntity;
import tr.com.r10.portal.repository.ProfessionRepository;
import tr.com.r10.portal.repository.RoleRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserConverter implements Converter<UserEntity, User> {
    private ProfessionRepository professionRepository;
    private CommentConverter commentConverter;
    private AddressConverter addressConverter;
    private RoleRepository roleRepository;

    @Override
    public UserEntity convertToEntity(User user) {
        if (Objects.isNull(user)) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());

        userEntity.setDisabled(user.isDisabled());
        userEntity.setAccountExpired(user.isAccountExpired());
        userEntity.setAccountLocked(user.isAccountLocked());
        userEntity.setCredentialsExpired(user.isCredentialsExpired());
        List<RoleEntity> roleList = user.getRoleList()
                .stream().map(role -> roleRepository.findByRoleName(role))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        userEntity.setRoles(roleList);

        userEntity.setInvitationCode(userEntity.getInvitationCode());
        List<ProfessionEntity> professionList = user.getProfessionList()
                .stream()
                .map(profession -> professionRepository.findAllByName(profession))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        userEntity.setProfessionList(professionList);
        List<CommentEntity> commentEntityList = commentConverter.convertToEntityList(user.getCommentList());
        userEntity.setCommentList(commentEntityList);
        userEntity.setAddressList(addressConverter.convertToEntityList(user.getAddressList()));
        return userEntity;
    }

    @Override
    public User convertToDTO(UserEntity userEntity) {
        if (Objects.isNull(userEntity)) {
            return null;
        }
        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        user.setInvitationCode(userEntity.getInvitationCode());

        user.setDisabled(userEntity.isDisabled());
        user.setAccountExpired(userEntity.isAccountExpired());
        user.setAccountLocked(userEntity.isAccountLocked());
        user.setCredentialsExpired(userEntity.isCredentialsExpired());
        List<String> roleList = userEntity.getRoles()
                .stream().map(RoleEntity::getRoleName)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        user.setRoleList(roleList);

        List<String> professionList = userEntity.getProfessionList()
                .stream()
                .map(profession -> professionRepository.findAllByName(profession.getName()))
                .filter(Objects::nonNull)
                .map(professionEntity -> professionEntity.getName())
                .collect(Collectors.toList());
        user.setProfessionList(professionList);
        List<Comment> commentList = commentConverter.convertToDTOList(userEntity.getCommentList());
        user.setCommentList(commentList);
        user.setAddressList(addressConverter.convertToDTOList(userEntity.getAddressList()));
        return user;
    }


    @Autowired
    public void setProfessionRepository(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setAddressConverter(AddressConverter addressConverter) {
        this.addressConverter = addressConverter;
    }

    @Autowired
    public void setCommentConverter(CommentConverter commentConverter) {
        this.commentConverter = commentConverter;
    }
}