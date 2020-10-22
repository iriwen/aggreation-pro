package com.java.code.autoconfig;

//import com.boot.autoconfig.MyStarterService;
//import com.boot.autoconfig.StarterProperties;

/**
 * created by yuxiaodong01 on 2020/06/24.
 */

// 当 MyStarterService 在类路径的条件下
//@ConditionalOnClass({MyStarterService.class})
//@EnableConfigurationProperties(StarterProperties.class)
//@ConditionalOnProperty(prefix = "spring.starter", value = "enabled", matchIfMissing = true)
//@Configuration
public class MyStarterConfiguration {

    /*@Autowired
    private StarterProperties properties;*/

    /*public StarterProperties getProperties() {
        return properties;
    }

    public void setProperties(StarterProperties properties) {
        this.properties = properties;
    }*/

    //@Bean
    // 当容器没有这个 Bean 的时候才创建这个 Bean
    //@ConditionalOnMissingBean(MyStarterService.class)
    public MyStarterService myStarterService(StarterProperties properties) {
        MyStarterService myStarterService = new MyStarterService();
        myStarterService.setWords(properties.getName());
        return myStarterService;
    }
}
