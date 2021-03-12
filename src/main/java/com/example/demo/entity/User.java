package com.example.demo.entity;

/**
 * 未整合shiro情况下的mybaits实体
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: test0.java
 * @description: 基于mybaits框架实体
 * @author: NiuYiq
 * @create: 2021-03-11 16:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private String password;
    private String perms;
}
