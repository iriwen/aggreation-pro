package com.manjaro.code.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "server")
@PropertySource(value= {"classpath:template.yml"},encoding="UTF-8")
public class PropertyConfig {

    private Map<String, Req> req1;
    public  Map<String,Req>  req2 ;

    public Map<String, Req> getReq1() {
        return req1;
    }

    public void setReq1(Map<String, Req> req1) {
        this.req1 = req1;
    }

    public Map<String, Req> getReq2() {
        return req2;
    }

    public void setReq2(Map<String, Req> req2) {
        this.req2 = req2;
    }

    private  static class Req implements Serializable {

        private Map<String,String>  headers;
        private Map<String,String>  body;

        public Map<String, String> getHeaders() {
            return headers;
        }

        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }

        public Map<String, String> getBody() {
            return body;
        }

        public void setBody(Map<String, String> body) {
            this.body = body;
        }
    }
}
