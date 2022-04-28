package com.roger.spring.annotation.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 用来测试生命周期的对象
 */
public class Person implements InitializingBean, DisposableBean {

    private String name;

    public Person(String name) {
        System.out.println("创建对象.....");
        this.name = name;
    }

    public void init() {
        System.out.println("init method........");
    }

    public void myDestroy() {
        System.out.println("myDestroy method.....");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct-----------");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy----------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set......");
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet-----------");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy------------");
    }
}
