package com.nagarro.customer.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nagarro.customer.model.Users;
import com.nagarro.customer.service.Authentication;

@Service
public class AuthenticationImpl implements Authentication {

	@Resource
	private Users users;
	
	public Users getUser() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	@Override
	public Users signup(String username, String password) {
		getUser().setId(1);
		getUser().setUsername(username);
		getUser().setPassword(password);
		return getUser();
	}

	@Override
	public boolean login(String username, String password) {
		if (username.equals(getUser().getUsername()) && password.equals(getUser().getPassword())) {
			return true;
		}
		return false;
	}

}
