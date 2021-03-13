package com.example.demo.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.nio.charset.StandardCharsets;

/**
 * @program: test0.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-13 10:17
 **/

public class TestMD5 {


    public static void main(String[] args) {
        //创建md5算法

        //使用md5
        Md5Hash md5Hash = new Md5Hash("nyq200103240059");
        System.out.println(md5Hash.toHex());    //转为16进制

        //使用MD5+salt
        System.out.println(new Md5Hash("nyq200103240059","*7skh").toHex());

        //使用md5 + salt + hash散列
        System.out.println(new Md5Hash("nyq200103240059","*7skh",1024).toHex());   //最后一个参数--散列次数
    }
}
