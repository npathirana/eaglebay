package com.eagle.commons.dao.util;

import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class NotNullOrBlankStringPropertySelector implements Example.PropertySelector {

    @Override
    public boolean include(Object o, String s, org.hibernate.type.Type type) {

        if (o != null) {
            if (o instanceof String) {
                return StringUtils.hasLength((String) o);
            } else if (o instanceof Short) {
                return true;
            } else if (o instanceof Integer) {
                return ((Integer) o) > 0;
            }
        } else {
            return false;
        }
        return true;
    }
}




