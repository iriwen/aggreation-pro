package com.java.code.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * created by yuxiaodong01 on 2020/10/20.
 */
public class JsonMapper {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getMapper(){
        return objectMapper;
    }

    public static String toJsonString(Object object) {
        String result = null;
        try {
             result= getMapper().writeValueAsString(object);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
