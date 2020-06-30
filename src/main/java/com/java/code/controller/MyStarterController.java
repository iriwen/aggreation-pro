package com.java.code.controller;

import com.boot.autoconfig.MyStarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by yuxiaodong01 on 2020/06/24.
 */
@RestController
@RequestMapping(value = "/starter")
public class MyStarterController {

    @Autowired
    private MyStarterService starterService;

    @RequestMapping(value = "/starterInfo")
    public Object getStarterInfo() {
        return starterService.sayHello();
    }
}
