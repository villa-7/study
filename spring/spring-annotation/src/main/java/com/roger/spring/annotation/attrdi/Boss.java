package com.roger.spring.annotation.attrdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {

    private Car car;

    public Car getCar() {
        return car;
    }

    /**
     * 测试构造方法注入
     */
    @Autowired
    public Boss(Car car) {
        this.car = car;
    }

    /**
     * 测试set方法注入
     */
    //@Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
