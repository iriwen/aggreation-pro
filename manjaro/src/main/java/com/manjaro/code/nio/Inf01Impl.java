package com.manjaro.code.nio;

public class Inf01Impl implements  Inf01 {

    @Override
    public String queryUserInfo() {
        return null;
    }

    @Override
    public String findUserInfo() {
        return this.getUserInfo();
    }
}
