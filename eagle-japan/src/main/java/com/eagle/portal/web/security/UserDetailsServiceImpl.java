package com.eagle.portal.web.security;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.security.SecurityManager;
import com.eagle.user.domain.User;
import com.eagle.user.domain.UserPermission;
import com.eagle.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    protected static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private UserService userService;

    @Autowired(required = true)
    public void setUserService(UserService userService) {
        if (logger.isDebugEnabled()) logger.debug("setting userService - {}", userService);
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Loading user - {}", username);

        UserDetails userDetails;
        User user;

        try {
            if (logger.isDebugEnabled()) logger.debug("userService-{}", userService);
            user = userService.getByEmail(username);
            if (logger.isDebugEnabled()) logger.debug("user - {}", user);
        } catch (ServiceException e) {
            if (logger.isErrorEnabled()) logger.error("Service call error", e);
            throw new UsernameNotFoundException(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        userDetails = new SecurityManager.CustomUserDetails(
                user,
                true, true, true, true,
                getAuthorities(user));

        if (userDetails.getAuthorities().isEmpty()) {
            logger.debug("User - {}, Permission count - 0", username);
            throw new UsernameNotFoundException(username);
        }

        return userDetails;
    }

    public Collection<GrantedAuthority> getAuthorities(User user) {

        List<GrantedAuthority> authList = new ArrayList<>();
        for (UserPermission userPermission : user.getPermissionList()) {
            authList.add(new SimpleGrantedAuthority("ROLE_" + userPermission.getPermission().getCode()));
        }

        if (logger.isDebugEnabled()) {

            // add permissions for testing:
            // authList.add(new SimpleGrantedAuthority(SecurityManager.Authorities.ROLE_USER));

            StringBuilder sb = new StringBuilder();
            for (GrantedAuthority grantedAuthority : authList) {
                sb.append(grantedAuthority.getAuthority()).append(",");
            }
            logger.debug("User[{}] Permissions: [{}]", user.getId(), sb.toString());
        }

        return authList;
    }


}