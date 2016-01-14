package com.eagle.portal.web.main.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sylenthira
 *         Date: 12/4/14
 *         Time: 11:49 AM
 */

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    /*@Autowired
    private UserCompanyService userCompanyService;*/


    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
                                        final HttpServletResponse response, final Authentication authentication)
            throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);


       /* try {
            UserCompany userCompany = userCompanyService.getUserCompany(com.eagle.user.security.SecurityManager.getCurrentUser().getId());
            int facId = userCompany.getCompany().getId();
            HttpSession session = request.getSession(true);
            session.setAttribute("factoryId", facId);
        } catch (com.eagle.cps.service.exception.ServiceException e) {
            e.printStackTrace();
        }*/


    }
}
