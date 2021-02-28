package com.nagarro.customersservice.service;

import javax.servlet.http.HttpSession;

import com.nagarro.customersservice.model.Customer;

public interface CustomerService {
	
	Customer createCustomer(String username, String password);
	
	Customer getCustomerByUsername(String username);
	
	boolean isLogged(String username, String password, HttpSession session);
	
	String requestForService(String requestService, HttpSession session);
}
