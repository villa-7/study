package com.roger.spring.aop.config;

import com.roger.spring.aop.LogAspects;
import com.roger.spring.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @EnableAspectJAutoProxy: 开启基于注解的AOP模式。
 */
@Configuration
@ComponentScan("com.roger.spring.aop")
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }
}
