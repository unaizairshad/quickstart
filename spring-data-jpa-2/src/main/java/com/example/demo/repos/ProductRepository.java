package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByProductName(String qryString);
	
	//findByPropertyName -P should be capital
	//public List<Product> findByRatePerUnit(int rate);

	
}
