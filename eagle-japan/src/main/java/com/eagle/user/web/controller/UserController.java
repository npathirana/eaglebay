package com.eagle.user.web.controller;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.util.DateUtil;
import com.eagle.commons.web.controller.ControllerBase;
import com.eagle.commons.web.controller.json.PostResponse;
import com.eagle.user.domain.User;
import com.eagle.user.security.UserAuthorities;
import com.eagle.user.service.UserService;
import com.eagle.user.web.dto.UserDto;
import com.eagle.user.web.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.eagle.commons.web.util.Constants.REQUEST_HEADER_ACCEPT_HTML;

@Controller
@RequestMapping("/" + Constants.MODULE_NAMESPACE + "/users")
public class UserController extends ControllerBase {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @InitBinder("user")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(DateUtil.dateFormatWeb, true));
    }

    @Secured(UserAuthorities.ROLE_USER_MODULE)
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home() {
        return Constants.JSP_PATH_USERS + "home";
    }

    @Secured(UserAuthorities.ROLE_USERS_LIST)
    @RequestMapping(method = RequestMethod.GET, headers = REQUEST_HEADER_ACCEPT_HTML)
    public String list(Model model) {
        return Constants.JSP_PATH_USERS + "list";
    }

    @Secured({UserAuthorities.ROLE_USERS_ADD, UserAuthorities.ROLE_USERS_EDIT,})
    @RequestMapping(method = RequestMethod.POST, headers = REQUEST_HEADER_ACCEPT_HTML)
    public
    @ResponseBody
    String persistUser(@ModelAttribute("user") UserDto userDto) {
        logger.debug("inside persistUser({}), ", userDto);

        PostResponse response = new PostResponse();
        User user = new User();
        // fill user object from userDto
        try {
            userService.save(user);

        } catch (ServiceException e) {
            setServiceError(response, e);
        }


        return response.toString();
    }

    @Secured(UserAuthorities.ROLE_USERS_DELETE)
    @RequestMapping(method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteUsers(@RequestParam(value = "id") List<Integer> idList) {
        PostResponse response = new PostResponse();
        try {
            userService.delete(idList);
        } catch (ServiceException e) {
            setServiceError(response, e);
        }
        return response.toString();
    }

}
