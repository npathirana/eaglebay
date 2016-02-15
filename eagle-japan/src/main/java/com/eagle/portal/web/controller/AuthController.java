/**
 *
 */
package com.eagle.portal.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    protected static Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * Handles and retrieves the login JSP page
     *
     * @param error
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,
                               ModelMap model) {
        logger.debug("Received request to show login page");

        if (error) {
            // Assign an error message
            model.put("error", "You have entered an invalid username or password!");
        } else {
            model.put("error", "");
        }

        return "main/loginpage";
    }

    /**
     * Handles and retrieves the login JSP page
     *
     * @param error
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/login", method = RequestMethod.HEAD)
    public String loginHeader(@RequestParam(value = "error", required = false) boolean error,
                              ModelMap model) {
        logger.debug("Received request to show login page");

        if (error) {
            // Assign an error message
            model.put("error", "You have entered an invalid username or password!");
        } else {
            model.put("error", "");
        }

        return "main/loginpage";
    }

    /**
     * Handles and retrieves the denied JSP page. This is shown whenever a regular user
     * tries to access an admin only page.
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String getDeniedPage(Model model) {
        logger.debug("label.error.access.denied");
        model.addAttribute("title", "label.error.access.denied");
        model.addAttribute("text", "label.error.access.denied.text");
        return "main/error-page";
    }

    @RequestMapping(value = "/duplicateLogin", method = RequestMethod.GET)
    public String getDuplicateLogin(Model model) {
        logger.debug("error.session.duplicated");
        model.addAttribute("title", "label.error.session.duplicated");
        model.addAttribute("text", "label.error.session.duplicated.text");
        return "main/error-page";
    }

}