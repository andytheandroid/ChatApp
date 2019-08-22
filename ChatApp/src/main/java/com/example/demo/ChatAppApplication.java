package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ChatAppApplication  extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(ChatAppApplication.class, args);
	}

	 public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/loginUser").setViewName("login");
	        registry.addViewController("/Scheduled").setViewName("Scheduled");
	        registry.addViewController("/index").setViewName("index");


	    }
	 
	
	 
	
	 
	 
}
