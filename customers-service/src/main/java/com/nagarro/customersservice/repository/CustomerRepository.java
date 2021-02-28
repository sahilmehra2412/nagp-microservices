package com.nagarro.customersservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.customersservice.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
