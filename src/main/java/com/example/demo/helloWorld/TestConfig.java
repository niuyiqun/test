package com.example.demo.helloWorld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-18 16:52
 **/

@Slf4j
public class TestConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(GuestConfig.class);
        Guest guest = context.getBean(Guest.class);
        System.out.println(guest);

        String[] guests = context.getBeanNamesForType(Guest.class);
        for (String s : guests) {
            System.out.println(s);
            log.info("###info###");
        }
    }
}
