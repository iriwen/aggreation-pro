package com.manjaro.code.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

public class Application01 {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MapServerProperties.class);

        Map beans = ctx.getBeansOfType(MapServerProperties.class);

        Object objectMapper = ctx.getBeansOfType(ObjectMapper.class);

        String[] defaultProfiles = ctx.getEnvironment().getDefaultProfiles();

        for(String s  :defaultProfiles){
            System.out.println(s);
        }

        String[] propertyConfigName = ctx.getBeanNamesForType(PropertyConfig.class);
        Stream.of(propertyConfigName).forEach(item->{
            System.out.println(item);
        });
    }


}
