package com.nagarro.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Users;

@RestController
@RequestMapping("/")
@EnableFeignClients
public class OrderController {
	
	@Autowired
	private RestTemplate resttemplate;
	
	@GetMapping
	@ResponseBody
	public Users getUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		return resttemplate.exchange("http://localhost:8000/?username="+username+"&password="+password, HttpMethod.GET, entity, Users.class).getBody();
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
