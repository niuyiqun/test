package com.example.demo.entity;
import lombok.Data;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class User implements Serializable, RowMapper<User> {


    private long id;

    @NotBlank(message = "用户名不能为空")
    @Length()
    private String username;

    @Email(message = "请输入邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18,message = "最小为18岁")
    @Max(value = 60,message = "最大为60岁")
    private int age;

    @NotBlank(message = "密码不能为空")
    private String password;

    public User(){

    }

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

}
