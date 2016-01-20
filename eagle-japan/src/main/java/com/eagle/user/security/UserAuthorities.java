
package com.eagle.user.security;

import com.eagle.commons.security.Authorities;
import org.springframework.stereotype.Component;

@Component
public class UserAuthorities implements Authorities {

    public static final String ROLE_USER_PREFIX = "ROLE_";
    public static final String ROLE_USER_MODULE = ROLE_USER_PREFIX + "USER_MODULE";

    public static final String ROLE_USERS_ADD = ROLE_USER_PREFIX + "USERS_ADD";
    public static final String ROLE_USERS_EDIT = ROLE_USER_PREFIX + "USERS_EDIT";
    public static final String ROLE_USERS_DELETE = ROLE_USER_PREFIX + "USERS_DELETE";
    public static final String ROLE_USERS_LIST = ROLE_USER_PREFIX + "USERS_LIST";
    public static final String ROLE_USERS_VIEW = ROLE_USER_PREFIX + "USERS_VIEW";

}
