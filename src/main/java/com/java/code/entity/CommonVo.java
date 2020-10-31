package com.java.code.entity;

/**
 * created by yuxiaodong01 on 2020/10/26.
 */
public class CommonVo {

    private String code;
    private String message;
    private Object data;
    public CommonVo() {
    }
    public CommonVo(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
