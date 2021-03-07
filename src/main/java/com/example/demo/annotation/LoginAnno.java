package com.example.demo.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented           //是否将注释信息添加在Java文档中
@Retention(RUNTIME)   //自定义的注释通常使用这种注释 RUNTIME
@Target(METHOD)       //将自定义注释放在什么地方，有一些枚举值
public @interface LoginAnno {     //该注解用来申明一个注解

}
