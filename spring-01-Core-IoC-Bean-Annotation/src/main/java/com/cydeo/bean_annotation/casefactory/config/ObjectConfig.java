package com.cydeo.bean_annotation.casefactory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectConfig {

    @Bean
    public String str(){
        return "This is my string";
    }

    @Bean

    public Integer num(){
        return 123;
    }
}
