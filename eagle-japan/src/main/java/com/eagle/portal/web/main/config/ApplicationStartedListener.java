
package com.eagle.portal.web.main.config;

import com.eagle.commons.security.Authorities;
import com.eagle.commons.web.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

@Component
public class ApplicationStartedListener implements ApplicationListener<ContextRefreshedEvent> {
    protected static Logger logger = LoggerFactory.getLogger(ApplicationStartedListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (logger.isDebugEnabled()) logger.debug("onApplicationEvent - {}", event);

        ApplicationContext appContext = event.getApplicationContext();
        if (appContext instanceof WebApplicationContext) {
            WebApplicationContext ctx = (WebApplicationContext) event.getApplicationContext();
            ServletContext context = ctx.getServletContext();

            context.setAttribute("springRootUrl", Constants.URL_SPRING_ROOT);

            //add authorities constants to context to use in JSPs
            Map<String, Authorities> authoritiesMap = appContext.getBeansOfType(Authorities.class);
            if (logger.isDebugEnabled()) logger.debug("authoritiesMap - {}", authoritiesMap);
            for (String authInterface : authoritiesMap.keySet()) {
                Authorities c = authoritiesMap.get(authInterface);
                setConstantsToContext(context, c.getClass());
            }
        }

    }

    private void setConstantsToContext(ServletContext ctx, Class c) {

        Field[] fields = c.getDeclaredFields();

        StringBuilder sb = null;
        if (logger.isDebugEnabled()) {
            sb = new StringBuilder("Setting ").append(c.getSimpleName()).append(" to ServletContext:");
        }

        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (Modifier.isFinal(modifier) && !Modifier.isPrivate(modifier)) {
                try {
                    ctx.setAttribute(field.getName(), field.get(c));
                    if (logger.isDebugEnabled()) {
                        if (sb != null) {
                            sb.append("Ctx.").append(field.getName()).append(" = ").append(field.get(c)).append(", ");
                        }
                    }

                } catch (IllegalAccessException e) {
                    logger.error("Cannot set SecurityManager to ServletContext", e);
                }
            }
        }
        if (logger.isDebugEnabled()) {
            if (sb != null && sb.length() > 0) {
                sb.setLength(sb.length() - 2);
                logger.debug(sb.toString());
            }

        }

    }

    private void shutDownApp(ContextRefreshedEvent event) {
        logger.error("APPLICATION STARTUP ERROR. SHUTTING DOWN..");
        ((ConfigurableApplicationContext) event.getApplicationContext()).close();
    }

}
