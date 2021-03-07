package com.example.demo.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <h5>描述:通过@Aspect注解使该类成为切面类</h5>
 */
@Aspect
@Component
public class LoginAnnoImpl {

    @Pointcut("@annotation(com.example.demo.annotation.LoginAnno)")
    private void cut() {
    }

    /**
     * <h5>功能:前置通知</h5>
     */
    @Before("cut()")
    public void before() {
        System.out.println("自定义注解生效了");
    }
}
