package com.nagarro.adminservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.adminservice.model.Request;

public interface AdminRepository extends CrudRepository<Request, Integer> {

}
