package com.nagarro.customer.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.customer.model.Users;
import com.nagarro.customer.service.Authentication;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private Authentication authentication;
	
	@GetMapping
	@ResponseBody
	public Users getUser(@RequestParam String username, @RequestParam String password) {
		return authentication.signup(username, password);
	}
	
	@GetMapping("/login")
	@ResponseBody
	public Map<String, Boolean> loginUser(@RequestParam String username, @RequestParam String password){
		Map<String, Boolean> msg = new HashMap<>();
		msg.put("message", authentication.login(username, password));
		return msg;
	}
}
