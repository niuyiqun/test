package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ServletComponentScan
@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class Test0Application {

	public static void main(String[] args) {
		SpringApplication.run(Test0Application.class, args);
	}

}
