package com.nagarro.customersservice.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.nagarro.customersservice.model.Customer;
import com.nagarro.customersservice.repository.CustomerRepository;
import com.nagarro.customersservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public Customer createCustomer(String username, String password) {
		Customer customer = new Customer();
		customer.setUsername(username);
		customer.setPassword(password);
		repository.save(customer);
		return customer;
	}


	@Override
	public Customer getCustomerByUsername(String username) {
		return jdbctemplate.queryForObject("select * from CUSTOMER where username=?", new BeanPropertyRowMapper<Customer>(Customer.class), username);
	}


	@Override
	public boolean isLogged(String username, String password, HttpSession session) {
		Customer customer = getCustomerByUsername(username);
		if (customer != null) {
			if (customer.getPassword().equals(password)){
				session.setAttribute("logged", username);
				return true;
			}
		}
		session.setAttribute("logged", null);
		return false;
	}


	@Override
	public String requestForService(String requestService, HttpSession session) {
		if (session.getAttribute("logged") != null) {
			return "Hi "+ (String) session.getAttribute("logged") + " you've requested for "+requestService;
		}
		return "Please Login";
	}
	
	

}
