package com.example.demo;

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

    private String username;
    
    @Field("Password")

    private	String password;
    
    private String[] roles;

    
    
    public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	@Field("logged")
    private boolean logged;
    
   
   public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isLogged() {
		return logged;
	}
	public void setLogged(boolean logged) {
		this.logged = logged;
	}
public String getUsername() {
		return username;
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
