package com.memeGenerator.fun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
@ComponentScan({"com"})
@EntityScan("com")
public class FunApplication {
	public static void main(String[] args) {
		SpringApplication.run(FunApplication.class, args);
	}
}
