
package com.eagle.portal.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    protected static Logger logger = LoggerFactory.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("Initializing AppContextListener..");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("Destroying AppContextListener..");
    }
}
