package com.java.code.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * created by iriwen on 2020/06/24.
 */

@ConfigurationProperties(prefix = "spring.starter")
public class StarterProperties {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
