package com.myproject.services;

import org.springframework.stereotype.Service;

import com.myproject.models.User;

@Service
public class Loginservice {

	public boolean validateUser(User user) {
		if(user.getUn().equalsIgnoreCase("SDatta") && user.getPw().equalsIgnoreCase("demo"))
			return true;
		else
			return false;
	}
}
