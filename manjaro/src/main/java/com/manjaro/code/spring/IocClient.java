package com.manjaro.code.spring;

import com.manjaro.code.entity.Employee;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * created by iriwen on 2020/06/18.
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
 *  委托模式(xml文件的解析)  模板方法模式（固定的步骤pre process post）
 *
 *  scope  用于后面工厂缓存的控制   bean 是缓存在currentHashMap中
 *  bean 注入构造器注入 和set 注入
 *  属性信息值解析并装配到BeanDefinition ，相应的bean注册之后 会触发观察者中的方法
 *
 */
public class IocClient {

    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("applicationContext.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //bean 信息定义读取器，用于读取bean的定义
        //bean 工厂同时也是bean定义的注册表 ,registry resourceLoader  environment  设置值
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(factory);

        //核心处理操作在这个方法上，流程多，本次注册过程中新增了多少bean
        //到这里bean还没有创建出来
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(resource);

        Employee employee = (Employee)factory.getBean("employee");

        System.out.println(employee.getName()+ "; id = "  + employee.getId());

    }
}
