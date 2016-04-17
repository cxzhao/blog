package com.blog.domain;

import java.io.Serializable;

import com.blog.enums.RoleEnum;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6234596831239892731L;
	private int id;
	private RoleEnum role;
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	
}
