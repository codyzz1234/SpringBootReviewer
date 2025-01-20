package com.example.SpringReviewerHelp.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class ServiceUtil {
    public static boolean checkIfStringIsNullOrEmpty(String value) {
        return StringUtils.isEmpty(value) || StringUtils.isEmpty(value.trim());
    }
}
