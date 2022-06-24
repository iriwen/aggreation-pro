package com.manjaro.code.model;


import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy(false)
public class Testlazy {

    public String name ;

    public Testlazy() {
        name = "test lazy properties ...." ;
        LocalDateTime  time = LocalDateTime.now() ;
        System.out.println("lazy bean start to instaniated ,time :" + time );
    }

    public String getName() {
        return this.name;
    }

    @PostConstruct
    public void init(){
        this.getName();

        System.out.println("test lazy  bean init .... ");
    }

    public void setName(String name) {
        this.name = name;
    }
}
