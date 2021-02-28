package com.nagarro.adminservice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.adminservice.model.Request;
import com.nagarro.adminservice.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/")
	public Request createRequest(@RequestParam final String requested_by, @RequestParam final String service_requested) {
		Request request = new Request();
		request.setRequested_by(requested_by);
		request.setService_requested(service_requested);
		Date date = new Date();
		request.setRequested_on(date);
		adminService.createNewRequest(request);
		return request;
	}
	
	@GetMapping("/assign")
	public Map<String, String> assignRequest(@RequestParam final int requestId, @RequestParam final String assignTo){
		Map<String, String> message = new HashMap<>();
		String msg = "Your request with id "+(String.valueOf(requestId)) + " assigned to "+assignTo;
		message.put("message", msg);
		return message;
	}
}
