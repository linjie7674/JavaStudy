package com.lj.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.lj.service")
public class SpringConfig {

    public SpringConfig(){
        System.out.println("SpringConfig constrcut");
    }
    
}
