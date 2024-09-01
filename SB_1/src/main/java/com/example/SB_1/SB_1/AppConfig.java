package com.example.SB_1.SB_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
//    by default bean is singleton
//    @Scope("singleton")
    @Scope("prototype")
    Apple gettApple() {
        return new Apple();
    }
}
