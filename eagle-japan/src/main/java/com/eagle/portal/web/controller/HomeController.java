package com.eagle.portal.web.controller;

import com.eagle.commons.web.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.eagle.commons.security.CommonAuthorities.ROLE_USER;

@Controller
@RequestMapping("/home")
public class HomeController {

    protected static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCommonPage(Model model) {

        //request for default page. checking for possible permissions
        String defaultAuth = com.eagle.commons.security.SecurityManager.getDefaultAuthority(
                ROLE_USER
        );

        logger.debug("defaultAuth - {}", defaultAuth);

        if (defaultAuth != null) {

            //load page according to permission
            switch (defaultAuth) {
                case ROLE_USER:
                    return Constants.URL_REDIRECT_MAIN_HOME;
            }
        }

        logger.debug("No permissions for: /home");
        return Constants.URL_REDIRECT_ACCESS_DENIED;

    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    @Secured(ROLE_USER)
    public String getAboutPage() {
        return "about";
    }


}


