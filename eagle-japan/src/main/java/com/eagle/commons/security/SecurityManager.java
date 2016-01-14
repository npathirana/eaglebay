
package com.eagle.commons.security;

import com.eagle.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

public class SecurityManager {

    protected static Logger logger = LoggerFactory.getLogger(SecurityManager.class);

    public static UserDetails getUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
        }

        return null;
    }

    public static CustomUserDetails getCurrentUser() {

        UserDetails ud = getUserDetails();

        if (ud instanceof CustomUserDetails) {
            return ((CustomUserDetails) ud);
        }

        return null;
    }

    public static String getDefaultAuthority(String... auths) {
        if (getUserDetails() != null) {
            for (String auth : auths) {
                logger.debug("check {}", auth);
                for (GrantedAuthority grantedAuthority : getUserDetails().getAuthorities()) {
                    if (auth.equals(grantedAuthority.getAuthority())) {
                        return grantedAuthority.getAuthority();
                    }
                }
            }
        }
        return null;
    }

    public static String encodePassword(String pwd) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(pwd);
    }

    public static class CustomUserDetails extends org.springframework.security.core.userdetails.User {

        private User dbUser;

        public CustomUserDetails(User dbUser, boolean enabled, boolean accountNonExpired,
                                 boolean credentialsNonExpired, boolean accountNonLocked,
                                 Collection<? extends GrantedAuthority> authorities) {
            super(dbUser.getEmail(), dbUser.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
            this.dbUser = dbUser;
        }

        public User getDbUser() {
            return dbUser;
        }

        public void setDbUser(User dbUser) {
            this.dbUser = dbUser;
        }
    }

}
