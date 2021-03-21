package com.example.demo.helloWorld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-18 16:40
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Guest {
    private int id;
    private String name;
    private int age;


}
