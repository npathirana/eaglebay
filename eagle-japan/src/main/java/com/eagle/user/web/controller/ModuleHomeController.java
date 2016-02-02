package com.eagle.user.web.controller;


import com.eagle.user.web.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(Constants.MODULE_NAMESPACE + "ModuleHomeController")
@RequestMapping("/" + Constants.MODULE_NAMESPACE)
public class ModuleHomeController {

    protected static Logger logger = LoggerFactory.getLogger(ModuleHomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage() {

        return Constants.MODULE_NAMESPACE + "/home";
    }

}


