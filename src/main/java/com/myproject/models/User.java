package com.myproject.models;

import org.springframework.stereotype.Component;

public class User {
	private String un;
	private String pw;
	
	public User(String userName, String password) {
		un = userName;
		pw = password;
	}

	public String getUn() {
		return un;
	}
	
	public String getPw() {
		return pw;
	}
}
