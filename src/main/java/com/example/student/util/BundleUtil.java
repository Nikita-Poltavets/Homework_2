package com.example.student.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BundleUtil {

    private static final ResourceBundle RESOURCE_GROUP_EN = ResourceBundle.getBundle("group_en");
    private static final ResourceBundle RESOURCE_GROUP_RU = ResourceBundle.getBundle("group_ru");
    private static final ResourceBundle RESOURCE_GROUP_UK = ResourceBundle.getBundle("group_uk");


    public static Map<String, String> getBundleProperties(String lang) {
        return convertResourceBundleToMap(getBundle(lang));
    }

    private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resource.getString(key));
        }
        return map;
    }

    private static ResourceBundle getBundle(String lang) {
        if (lang.isBlank() || lang.equals("en")) {
            return RESOURCE_GROUP_EN;
        } else if (lang.equals("ru")){
            return RESOURCE_GROUP_RU;
        } else {
            return RESOURCE_GROUP_UK;
        }
    }

}
