package com.roger.spring.annotation.attrdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 测试属性注入
 */
@Configuration
@ComponentScan("com.roger.spring.annotation.attrdi")
public class AttrDIConfig {

    @Bean
    public Car car() {
        return new Car();
    }

    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
