package com.example.demo.LoginModule;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "User")
@Entity
public class  Users {
	
    @Id
    public String id;
    
    @Field("Username")

    private String Username;
    
    @Field("Password")

    private	String Password;
    
   
   public String getUsername() {
		return Username;
	}
	public Users(String username, String password) {
		super();
		this.Username = username;
		this.Password = password;
	}
	
	
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}

}
