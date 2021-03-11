package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: test0.java
 * @description: 基于jpa模块生成的实体类
 * @author: NiuYiq
 * @create: 2021-03-11 15:32
 **/

@Entity
@Data
public class boyFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;


}


