
package com.eagle.commons.security;

import org.springframework.stereotype.Component;

@Component
public class CommonAuthorities implements Authorities {

    public static final String ROLE_PREFIX = "ROLE_";
    public static final String ROLE_USER = ROLE_PREFIX + "USER";

}
