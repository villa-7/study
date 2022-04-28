package com.roger.bytebuddy.agent.bean;

public class User {

    private String name;

    public String sayHello(String to) {
        return "hello " + to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
