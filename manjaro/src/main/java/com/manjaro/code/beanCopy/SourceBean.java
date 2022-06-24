package com.manjaro.code.beanCopy;

import java.io.Serializable;
import java.util.Map;

public class SourceBean implements Serializable {

    public String name;

    public Map<String,String>  headers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
