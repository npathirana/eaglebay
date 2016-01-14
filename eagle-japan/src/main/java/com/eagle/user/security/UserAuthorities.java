
package com.eagle.user.security;

import com.eagle.commons.security.Authorities;
import org.springframework.stereotype.Component;

@Component
public class UserAuthorities implements Authorities {

    public static final String ROLE_USER_PREFIX = "ROLE_USER_";
    public static final String ROLE_USER_MODULE = ROLE_USER_PREFIX + "MODULE";

    public static final String ROLE_USER_ADD = ROLE_USER_PREFIX + "USER_ADD";
    public static final String ROLE_USER_EDIT = ROLE_USER_PREFIX + "USER_EDIT";
    public static final String ROLE_USER_DELETE = ROLE_USER_PREFIX + "USER_DELETE";
    public static final String ROLE_USER_LIST = ROLE_USER_PREFIX + "USER_LIST";
    public static final String ROLE_USER_VIEW = ROLE_USER_PREFIX + "USER_VIEW";

}
