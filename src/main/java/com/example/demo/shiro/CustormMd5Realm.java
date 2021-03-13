package com.example.demo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @program: test0.java
 * @description: 认证md5加密后的数据
 * @author: NiuYiq
 * @create: 2021-03-13 10:26
 **/

public class CustormMd5Realm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String principal = (String) token.getPrincipal();

        if ("xiaochen".equals(principal)){

            return new SimpleAuthenticationInfo(principal,"e52c4a472bed1653e097c72d175491f6",
                    this.getName());
        }
        return null;

    }

}
