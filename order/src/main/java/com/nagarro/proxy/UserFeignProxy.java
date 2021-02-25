package com.nagarro.proxy;

import javax.servlet.http.HttpSession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.model.Users;

@FeignClient(name="customer-service", url="localhost:8000")
public interface UserFeignProxy {
	
	@GetMapping("/")
	public Users getUser(@RequestParam String username, @RequestParam String password,
			final HttpSession session);
}
