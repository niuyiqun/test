package com.example.demo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @program: test0.java
 * @description: 自定义realm
 * @author: NiuYiq
 * @create: 2021-03-12 20:58
 **/

public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {    //授权
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        System.out.println(principal);
        if ("xiaochen".equals(principal)){
            return new SimpleAuthenticationInfo("xiaochen","123",this.getName());
            //返回值SimpleAuthenticationInfo类型，包含用户名和密码，最后一个参数为realm的名字
        }

        return null;
    }    //认证
}
