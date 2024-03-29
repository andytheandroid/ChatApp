package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	LoginService loginService;
	
	 @Autowired
	 SecuritySucessHandler successHandler;


	  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	  http.csrf().disable()
          .authorizeRequests()
              .antMatchers(
            		  "/",
            		  "/newUser",
            		  "/Error",
            		  "/register",
            		  "/Sucess",
            		 "/home",
            		  "/403",
                      "/js/**",
                      "/css/**",
                      "/images/**",
                      "/vendor/**",
                      "/webjars/**").permitAll().
             
             anyRequest().authenticated()
             .and()
         .formLogin().loginPage("/login").loginProcessingUrl("/loginUser")
         .permitAll()
         .usernameParameter("username")
         .passwordParameter("password")
         .successHandler(successHandler)
         .and()
         .logout()                                    
             .permitAll();
          http.exceptionHandling().accessDeniedPage("/403");

    	  
    	  
    }

    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
     }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
   builder.userDetailsService(loginService).passwordEncoder(passwordEncoder());
     
     
    }
}