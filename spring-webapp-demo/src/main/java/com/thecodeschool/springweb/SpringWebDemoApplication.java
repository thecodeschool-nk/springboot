package com.thecodeschool.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.thecodeschool.springweb")
public class SpringWebDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebDemoApplication.class, args);
	}
}
