package com.nagarro.customersservice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.customersservice.model.Customer;
import com.nagarro.customersservice.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/")
	@ResponseBody
	public Customer createCustomer(@RequestParam final String username, @RequestParam String password) {
		return service.createCustomer(username, password);
	}
	
	@GetMapping("/get/{username}")
	@ResponseBody
	public Customer getCustomer(@PathVariable final String username) {
		return service.getCustomerByUsername(username);
	}
	
	@GetMapping("/login")
	@ResponseBody
	public boolean isLogged(@RequestParam final String username, @RequestParam String password, HttpSession session) {
		return service.isLogged(username, password, session);
	}
	
	@GetMapping("/requestService")
	@ResponseBody
	public String requestService(@RequestParam final String serviceRequest, HttpSession session) {
		return service.requestForService(serviceRequest, session);
	}

}
