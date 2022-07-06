package com.manjaro.code.controller;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
public class Lazycontroller {

    //@Autowired
    //Testlazy  testlazy ;

    @GetMapping("/hello")
    public String getLazyBean() {
        //String  sds =  testlazy.getName();

        //return "hello :" + sds ;
        return "" ;
    }

    @GetMapping("/test")
    @Cacheable(key="testlazy")
    public String testLazyBean(){
        System.out.println("method 。。。");
        /*if(testlazy == null || ! (testlazy instanceof Testlazy) ){
            System.out.println("lazy is null !!");
        }
        return "test :"  + testlazy.getName();*/
        return "";
    }
}
