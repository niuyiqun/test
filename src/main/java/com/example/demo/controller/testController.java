package com.example.demo.controller;


import com.example.demo.annotation.LoginAnno;
import com.example.demo.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class testController {

//    @RequestMapping("/hello")
//    public String test(){
//        return "hello";
//    }
//    @GetMapping("/helloWorld")
//    public Mono<String> helloWorld(){
//        return Mono.just("this is WebFlux demo");
//    }

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "yes";
    }

    @GetMapping("reg")
    public String reg(String userName) {
        return "用户[" + userName +"]注册成功~!";
    }

//    @RequestMapping("login")
//    @LoginAnno
//    public String login(String userName) {
//        return "欢迎您:" + userName;
//    }

    @RequestMapping("/BusinessException")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if (i==0){
            throw new BusinessException(600,"自定义业务错误");
        }
        return "success";
    }


}
