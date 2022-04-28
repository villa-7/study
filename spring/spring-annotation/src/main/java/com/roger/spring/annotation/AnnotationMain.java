package com.roger.spring.annotation;

import com.roger.spring.annotation.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器创建完成");

        // 关闭容器
        applicationContext.close();
    }
}
