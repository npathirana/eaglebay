
package com.eagle.commons.web.util;

import org.springframework.http.MediaType;

public interface Constants {

    String ACCEPT = "Accept";
    String REQUEST_HEADER_ACCEPT_JSON = ACCEPT + "=" + MediaType.APPLICATION_JSON_VALUE;
    String REQUEST_HEADER_ACCEPT_HTML = ACCEPT + "=" + MediaType.TEXT_HTML_VALUE;

    String URL_SPRING_ROOT = "/cps";
    String MAIN_MODULE_NAMESPACE = "main";
    String URL_REDIRECT_ACCESS_DENIED = "redirect:" + URL_SPRING_ROOT + "/auth/denied";
    String URL_REDIRECT_HOME = "redirect:" + URL_SPRING_ROOT + "/home";
    String URL_REDIRECT_MAIN_HOME = "redirect:" + URL_SPRING_ROOT + "/main/home";

}
