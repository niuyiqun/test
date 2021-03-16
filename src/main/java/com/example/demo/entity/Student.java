package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-16 15:24
 **/

@Component
@Data
public class Student implements Serializable {
    private int id;
    private String name;
    private String password;

    public Student() {
    }

    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

