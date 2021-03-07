package com.example.demo.entity;


import lombok.Data;

@Data
public class Grade {

    private Integer gradeId;
    private String gradeName;

    public Grade() {

    }

    public Grade(String gradeName) {
        this.gradeName = gradeName;
    }

    public Grade(Integer gradeId, String gradeName) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
    }

}
