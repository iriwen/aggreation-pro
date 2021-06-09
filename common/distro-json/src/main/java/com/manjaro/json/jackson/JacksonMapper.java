package com.manjaro.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * created by iriwen on 2020/10/20.
 */
public class JacksonMapper {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getMapper(){
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //objectMapper.setDateFormat();
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
