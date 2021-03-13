package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

















/**
 * 未整合shiro情况下的mybaits实体mapping
 */
/**
 * @author niu
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") int id);

    @Select("SELECT * FROM user limit 1000")
    List<User> queryAll();

    @Insert({"INSERT INTO user(name,password) VALUES(#{name},#{password})"})
    int add(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    int delById(int id);

    @Update("UPDATE user SET name=#{name},age=#{age} WHERE id = #{id}")
    int updateById(User user);
//
    @Select("SELECT * FROM user limit 1000")
    Page<User> getUserList();

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);
}
