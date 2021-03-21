package com.example.demo.helloWorld;

import org.springframework.context.annotation.Bean;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-17 19:19
 **/

public class testAnno extends Object{
    @Deprecated
    public void say(){
        System.out.println("before");
    }

    @Bean
    public static void main(String[] args) {
        new testAnno().say();
    }
}
