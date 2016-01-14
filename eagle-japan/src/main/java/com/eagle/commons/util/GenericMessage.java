package com.eagle.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GenericMessage {

    private static Logger logger = LoggerFactory.getLogger(GenericMessage.class);
    @Autowired
    private MessageSource messageSource;

    public String getLocalizedMessage(String key, Object... params) {
        try {
            return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            logger.error(e.getMessage());
            return String.format("{%s}", key);
        }
    }
}
