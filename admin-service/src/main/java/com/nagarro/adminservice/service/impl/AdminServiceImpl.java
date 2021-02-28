package com.nagarro.adminservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.adminservice.model.Request;
import com.nagarro.adminservice.repository.AdminRepository;
import com.nagarro.adminservice.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Request createNewRequest(Request request) {
		adminRepository.save(request);
		return request;
	}

}
