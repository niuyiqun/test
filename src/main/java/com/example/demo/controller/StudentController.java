package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-16 15:25
 **/

@RestController
public class StudentController {
    //用RedisTemplate类来存取对象
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private Student student01,student02;

    @PostMapping("/student/{id}/{name}/{password}")
    public void setStudent(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("password") String password){
        student01.setId(Integer.valueOf(id));
        student01.setName(name);
        student01.setPassword(password);
        redisTemplate.opsForValue().set("student_1",student01);//存对象
        student02=(Student)redisTemplate.opsForValue().get("student_1");//取对象，查看存储是否成功
        System.out.println(student02);
    }
}

