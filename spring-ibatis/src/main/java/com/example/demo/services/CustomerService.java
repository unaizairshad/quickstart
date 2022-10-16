package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifaces.CrudRepository;
import com.example.demo.model.Customer;


@Service
public class CustomerService {
	
	@Autowired
	private CrudRepository repo;
	
	public boolean save(Customer entity) {
		return this.repo.save(entity);//its not this.save() its this.repo.save()  
		
	}
	
	public List<Customer> findAll(){
		return this.repo.findAll();
	}

}
