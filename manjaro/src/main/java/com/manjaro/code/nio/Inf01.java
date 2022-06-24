package com.manjaro.code.nio;

import org.springframework.beans.factory.annotation.Autowired;

public interface Inf01 {

    default String  getUserInfo(){
        return "parent";
    }

    String queryUserInfo();


    String findUserInfo();
}
