package com.example.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-12 21:01
 **/

public class TestCustomerRealm {

    public static void main(String[] args) {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(new CustomerRealm());
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen", "123");
        try {
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
