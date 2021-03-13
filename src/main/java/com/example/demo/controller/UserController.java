package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.shiro.CustomerRealm;
import com.example.demo.shiro.UserRealm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author longzhonghua
 * mybaits
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;


    //注册业务
    @RequestMapping("/register")
    public String register(){

        return "user/register";
    }
    @RequestMapping("/registerTest")
    public String registerTest(User user){
        //直接存储md5加密后的十六进制进数据库
        Md5Hash md5Hash=new Md5Hash(user.getPassword());
        user.setPassword(md5Hash.toHex());
        userMapper.add(user);
        System.out.println("存储成功");
        return "redirect:/user/login";
    }

    //登录业务
    @RequestMapping("/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping("/loginTest")
    @ResponseBody
    public String loginTest(User user){        //检查是否与数据库中信息匹配
        //创建securityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //设置为自定义realm获取认证数据
        UserRealm userRealm = new UserRealm();
        //设置md5加密
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        defaultSecurityManager.setRealm(userRealm);
        //将安装工具类中设置默认安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建token令牌
        String md5password = new Md5Hash(user.getPassword()).toHex();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), md5password);
        try {
            subject.login(token);
            System.out.println("登录成功");
        }catch (UnknownAccountException e){
            return "用户不存在";
        }catch (IncorrectCredentialsException e){
            return "密码错误";
        }

        return "登录成功";
    }




//    @Autowired
//    UserMapper userMapper;
//
//    @RequestMapping("/querybyid")
//    User queryById(int id) {
//        return userMapper.findById(id);
//    }
//
//    @RequestMapping("/")
//    List<User> queryAll() {
//        return userMapper.queryAll();
//    }
//
//
//    @RequestMapping("/add")
//    String add(User user) {
//        return userMapper.add(user) == 1 ? "success" : "failed";
//    }
//
//    @RequestMapping("/updatebyid")
//    String updateById(User user) {
//        return userMapper.updateById(user) == 1 ? "success" : "failed";
//    }
//
//    @RequestMapping("/delbyid")
//    String delById(int id) {
//        return userMapper.delById(id) == 1 ? "success" : "failed";
//    }
//
//    @RequestMapping("/addalot")
//    void addUserAlot() {
//        for (int i=0;i<10;i++){
//            User user=new User();
//            user.setId(i);
//            user.setAge(i+20);
//            user.setName("niu");
//            userMapper.add(user);
//        }
//
//    }
//
//    @RequestMapping("/login")
//    public String login(String name,String password){
//        System.out.println("name="+name);
//        /**
//         * 使用Shiro编写认证操作
//         */
//        //1.获取Subject
//        Subject subject = SecurityUtils.getSubject();
//
//        //2.封装用户数据
//        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
//
//        //3.执行登录方法
//        try {
//            subject.login(token);
//
//            //登录成功
//            //跳转到test.html
//            return "/user/success";
//        } catch (UnknownAccountException e) {
//            //e.printStackTrace();
//            //登录失败:用户名不存在，UnknownAccountException是Shiro抛出的找不到用户异常
////            model.addAttribute("msg", "用户名不存在");
//            return "/user/wrongUsername";
//        }catch (IncorrectCredentialsException e) {
//            //e.printStackTrace();
//            //登录失败:密码错误，IncorrectCredentialsException是Shiro抛出的密码错误异常
////            model.addAttribute("msg", "密码错误");
//            return "/user/wrongPassword";
//        }
//    }

}