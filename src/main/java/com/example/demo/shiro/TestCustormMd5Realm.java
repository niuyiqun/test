package com.example.demo.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-13 10:27
 **/

public class TestCustormMd5Realm {

    public static void main(String[] args) {

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        CustormMd5Realm realm = new CustormMd5Realm();

        //设置realm使用hash凭证匹配器    CredentialsMatcher凭证匹配器  默认是明文
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");  //设置密码匹配的方式
        hashedCredentialsMatcher.setHashIterations(1024);   //设置散列的次数
        realm.setCredentialsMatcher(hashedCredentialsMatcher);


        defaultSecurityManager.setRealm(realm);


        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen", "nyq200103240059");
        try {
            subject.login(token);
            System.out.println("登录成功");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
    }


}
