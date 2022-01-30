package tr.com.r10.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tr.com.r10.portal.dao.interfaces.UserDao;
import tr.com.r10.portal.exceptions.NotFoundException;
import tr.com.r10.portal.model.RoleEntity;
import tr.com.r10.portal.model.UserEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    BCryptPasswordEncoder bCryptPasswordEncoder;
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userDao.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new NotFoundException("User not found for username is " + username);
        }
        List<String> roleList = user.getRoles()
                .stream().map(RoleEntity::getRoleName)
                .collect(Collectors.toList());

        // todo field adding userfield
        return User.builder()
                //change here to store encoded password in db
                .password( bCryptPasswordEncoder.encode(user.getPassword()) )
                .disabled(user.isDisabled())
                .accountExpired(user.isAccountExpired())
                .accountLocked(user.isAccountLocked())
                .credentialsExpired(user.isCredentialsExpired())
                .roles(roleList.toArray(new String[0]))
                .build();
    }

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
