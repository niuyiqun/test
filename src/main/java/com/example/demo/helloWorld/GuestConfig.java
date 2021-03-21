package com.example.demo.helloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-18 16:43
 **/

@Configuration
public class GuestConfig {



    @Bean
    public Guest getGuest1(){
        return new Guest(1,"niu",18);
    }


}
