package com.manjaro.code.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "server1")
@PropertySource("template.yml")
public class MapServerProperties {

    //@Value("${name}")
    private String name ;

    //@Value("${passwd}")
    private String passwd ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    /* private Map<String, String> root;


    public Map<String, String> getRoot() {
        return root;
    }

    public void setRoot(Map<String, String> root) {
        this.root = root;
    }

    @Data
    public static class Credential {

        private String username;
        private String password;
    }*/
}
