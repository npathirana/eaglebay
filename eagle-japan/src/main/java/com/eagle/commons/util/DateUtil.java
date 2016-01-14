package com.eagle.commons.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 *
 * @author chamila
 *         Date: 1/23/12
 *         Time: 10:21 AM
 */
public class DateUtil extends java.util.Date {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

    public static SimpleDateFormat dateFormatWeb = new SimpleDateFormat("yyyy/MM/dd");

    static {
        dateFormatWeb.setLenient(false);
    }

}
