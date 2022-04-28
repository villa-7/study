package com.roger.spring.annotation.config;

import com.roger.spring.annotation.bean.Person;
import com.roger.spring.annotation.bean.Pet;
import com.roger.spring.annotation.processor.MyBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.roger.spring")
public class MyConfig {

    @Bean(initMethod = "init", destroyMethod = "myDestroy")
    public Person person() {
        Person person = new Person("zhangsan");
        person.setName("lisi");
        return person;
    }

    @Bean
    public Pet pet() {
        return new Pet("pig");
    }

    @Bean
    public BeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

}
