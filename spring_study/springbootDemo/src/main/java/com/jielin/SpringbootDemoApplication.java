package com.jielin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        System.out.println("java.version: " + System.getProperty("java.version"));
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
