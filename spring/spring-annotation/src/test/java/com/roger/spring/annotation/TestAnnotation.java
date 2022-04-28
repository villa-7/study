package com.roger.spring.annotation;

import com.roger.spring.annotation.attrdi.AttrDIConfig;
import com.roger.spring.annotation.attrdi.Boss;
import com.roger.spring.annotation.attrdi.Car;
import com.roger.spring.annotation.attrdi.Color;
import com.roger.spring.annotation.bean.User;
import com.roger.spring.annotation.config.MyConfig;
import com.roger.spring.annotation.config.ValueConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {

    @Test
    public void testLifePeriod() {
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器创建完成");

        // 关闭容器
        applicationContext.close();
    }

    @Test
    public void testValue() {
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValueConfig.class);
        System.out.println("容器创建完成");

        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        // 关闭容器
        applicationContext.close();
    }

    @Test
    public void testDI() {
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AttrDIConfig.class);
        System.out.println("容器创建完成");

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        // 关闭容器
        applicationContext.close();
    }

}
