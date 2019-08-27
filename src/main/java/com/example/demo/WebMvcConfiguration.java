package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.example.demo")
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("/");

        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/Main").setViewName("Main");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/logout").setViewName("logout");



        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      if (!registry.hasMappingForPattern("/assets/**")) {
         registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
      }
    }
  
}