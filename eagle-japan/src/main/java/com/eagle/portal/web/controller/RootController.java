package com.eagle.portal.web.controller;

import com.eagle.commons.web.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles and retrieves the common or admin page depending on the URI template.
 * A user must be log-in first he can access these pages.  Only the admin can see
 * the adminpage, however.
 */
@Controller
@RequestMapping(Constants.URL_SPRING_ROOT)
public class RootController {

    protected static Logger logger = LoggerFactory.getLogger(RootController.class);

    @RequestMapping(value = {""})
    public String start() {
        return Constants.URL_REDIRECT_HOME;
    }

}
