package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class MyUtils {

    public static boolean areAllFieldsNull(Object obj) {
        if (obj == null) {
            return true;
        }

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true); // private 필드에 접근할 수 있도록 설정
            try {
                if (field.get(obj) != null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                log.info("[areAllFieldsNullMethodEx] = {}", e.getMessage());
            }
        }
        return true;
    }

}
