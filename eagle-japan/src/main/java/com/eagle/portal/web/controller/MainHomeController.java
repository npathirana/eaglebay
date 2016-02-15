package com.eagle.portal.web.controller;


import com.eagle.commons.security.CommonAuthorities;
import com.eagle.commons.web.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/" + Constants.MAIN_MODULE_NAMESPACE + "/home")
public class MainHomeController {

    protected static Logger logger = LoggerFactory.getLogger(MainHomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage(Model model) {
        logger.debug("Loaded Home Page");
        model.addAttribute("displayModulePermission", CommonAuthorities.ROLE_USER);
        return "home";

    }

}


