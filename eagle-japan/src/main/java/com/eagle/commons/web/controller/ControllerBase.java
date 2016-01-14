package com.eagle.commons.web.controller;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.web.controller.json.PostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ControllerBase {

    private static Logger logger = LoggerFactory.getLogger(ControllerBase.class);

    @Qualifier("messageSource")
    @Autowired
    protected MessageSource messageSource;

    public String getMessage(String key, Object... params) {
        try {
            return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            logger.error(e.getMessage());
            return String.format("{%s}", key);
        }
    }

    protected void setServiceError(PostResponse response, ServiceException e) {
        if (e.getMessage().startsWith("label.error") || e.getMessage().matches("label\\.[^\\.]+\\.error.*")) {  //check for label.module A.error.bbb
            response.setErrors(new String[]{messageSource.getMessage(e.getMessage(), e.getMessageArgs(), LocaleContextHolder.getLocale())});
        } else {
            response.setErrors(new String[]{e.getMessage()});
        }
    }

}
