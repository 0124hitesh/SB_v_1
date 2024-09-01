package com.example.SB_1.SB_1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component
//Comment Compenent annotation to use this class methods via AppConfig
// Component will make Apple as a bean
public class Apple {
    void eatApple() {
        System.out.println("eating APPle");
    }

    @PostConstruct
    void callThisBeforeAppleUsed() {
        System.out.println("Apple going to be used");
    }

    @PreDestroy
    void appleWillDestroy() {
        System.out.println("Apple will destroy");
    }
}
