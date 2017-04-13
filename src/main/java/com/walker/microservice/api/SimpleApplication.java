package com.walker.microservice.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by walker on 2017/4/11.
 */
@SpringBootApplication(scanBasePackages = "com.walker.microservice")
public class SimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }
}
