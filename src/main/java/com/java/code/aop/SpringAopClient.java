package com.java.code.aop;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * created by yuxiaodong01 on 2020/06/26.
 */
public class SpringAopClient {

    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //bean 信息定义读取器，用于读取bean的定义
        //bean 工厂同时也是bean定义的注册表 ,registry resourceLoader  environment  设置值
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);

        //核心处理操作在这个方法上，流程多，本次注册过程中新增了多少bean
        //到这里bean还没有创建出来
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(resource);

        MyAopService myAdvisedService = (MyAopService)factory.getBean("myAdvisedService");

        myAdvisedService.method();

        Class<?>[] interfaces = myAdvisedService.getClass().getInterfaces();

        for (int i = 0; i < interfaces.length; i++) {

            System.out.println(interfaces[i]);
        }
    }
}
