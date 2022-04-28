package com.roger.spring.annotation.config;

import com.roger.spring.annotation.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/user.properties")
public class ValueConfig {

    @Bean
    public User user() {
        return new User();
    }

}
