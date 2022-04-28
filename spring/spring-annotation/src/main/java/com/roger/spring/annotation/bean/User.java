package com.roger.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 测试@Value属性注入
 */
public class User{

    @Value("${user.name}")
    private String name;

    @Value("wudds")
    private String nickName;

    @Value("#{20-2}")
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}
