package com.java.code.spring;

import com.java.code.entity.Employee;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * created by yuxiaodong01 on 2020/06/18.
 *
 * spring 中的environment环境提供了 profiles 和 properties的封装,可以 1对程序各种属性的配置，2对程序运行环境的profile的设定
 *
 * 工厂对象可以实现environmentCaple（里面的方法可以返回environment对象） 也可以不实现
 *
 *  spring框架内部的一些类 还是new出来的
 *  字符集（charset）通过字符编码（encode）去构造的
 *  sax是流式解析（spring默认的方式），dom对内存要求较高
 *
 *  spring 的方法以do开头的基本都是内部使用的方法
 *
 *  委托模式  模板方法设计模式
 *
 *  scope  用于后面工厂缓存的控制   bean 是缓存在currentHashMap中
 *
 */
public class SpringClent {

    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //bean 信息定义读取器，用于读取bean的定义
        //bean 工厂同时也是bean定义的注册表 ,registry resourceLoader  environment  设置值
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);

        //核心处理操作在这个方法上，流程多
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(resource);

        Employee employee = (Employee)factory.getBean("employee");

        System.out.println(employee.getName()+ " ;"  + employee.getId() );

    }
}
