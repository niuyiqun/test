package com.example.demo.shiro;



import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;

/**
 * @program: test0.java
 * @description: shiro整合到mybaits
 * @author: NiuYiq
 * @create: 2021-03-12 16:12
 **/

/**
 * 自定义Realm
 * （1）AuthenticatingRealm：shiro中的用于进行认证的领域，实现doGetAuthentcationInfo方法实现用户登录时的认证逻辑；
 * （2）AuthorizingRealm：shiro中用于授权的领域，实现doGetAuthrozitionInfo方法实现用户的授权逻辑，AuthorizingRealm继承了AuthenticatingRealm，
 *  所以在实际使用中主要用到的就是这个AuthenticatingRealm类；
 * （3）AuthenticatingRealm、AuthorizingRealm这两个类都是shiro中提供了一些线程的realm接口
 * （4）在与spring整合项目中，shiro的SecurityManager会自动调用这两个方法，从而实现认证和授权，可以结合shiro的CacheManager将认证和授权信息保存在缓存中，
 *  这样可以提高系统的处理效率。
 *
 */
public class UserRealm extends AuthorizingRealm{    //继承此筹项类

    @Autowired
    UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {



        System.out.println("身份认证");
        String principal = (String) token.getPrincipal();
        User user = userMapper.findByName(principal);
        if (user == null){
            return null;
        }
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(principal, password, this.getName());
            //SimpleAuthenticationInfo中的信息是数据库中的信息


    }


//    /**
//     * 执行认证逻辑
//     */
//    @Override  // 源码中最终执行认证的方法，继承了之后可以自己编写realm
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
//        System.out.println("执行认证逻辑");
//
//        //编写shiro判断逻辑，判断用户名和密码
//        //1.判断用户名  token中的用户信息是登录时候传进来的
//        UsernamePasswordToken token = (UsernamePasswordToken)arg0;
//
//        User user = userMapper.findByName(token.getUsername());
//
//        if(user==null){
//            //用户名不存在
//            return null;//shiro底层会抛出UnKnowAccountException
//        }
//
//        //2.判断密码
//        //第二个字段是user.getPassword()，注意这里是指从数据库中获取的password。第三个字段是realm，即当前realm的名称。
//        //这块对比逻辑是先对比username，但是username肯定是相等的，所以真正对比的是password。
//        //从这里传入的password（这里是从数据库获取的）和token（filter中登录时生成的）中的password做对比，如果相同就允许登录，
//        //不相同就抛出IncorrectCredentialsException异常。
//        //如果认证不通过，就不会执行下面的授权方法了
//        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
//    }
//
//    /**
//     * 执行授权逻辑
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {    //授权方法
//
//
//        //doGetAuthorizationInfo方法可能会执行多次，权限判断次数多少，就会执行多少次
//        System.out.println("执行授权逻辑1");
//        System.out.println("执行授权逻辑2");
//
//        //给资源进行授权
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        //添加资源的授权字符串
//        //info.addStringPermission("user:add");
//
//        //到数据库查询当前登录用户的授权字符串
//        //获取当前登录用户
//        Subject subject = SecurityUtils.getSubject();
//        User user = (User)subject.getPrincipal();
//        User dbUser = userMapper.findById(user.getId());
//
//        info.addStringPermission(dbUser.getPerms());
//
//        return info;
//    }
}

