package com.nagarro.customer.service;

import com.nagarro.customer.model.Users;

public interface Authentication {
	Users signup(String username, String password);
	
	boolean login(String username, String password);
}
