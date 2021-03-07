package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;



@ServletComponentScan
@SpringBootApplication
public class Test0Application {

	public static void main(String[] args) {
		SpringApplication.run(Test0Application.class, args);
	}

}
