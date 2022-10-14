package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepository;

@Service
public class ProductServices {
	
	private ProductRepository repo;

	@Autowired
	public ProductServices(ProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Product save(Product entity) {
		return this.repo.save(entity);
	}
	
	public List<Product> findAll(){
		return this.repo.findAll();
	}
	
	
	public List<Product> findByProductName(String srchString){
		return this.repo.findByProductName(srchString);
		
	}
	
	public void deleteById(int key) {
		if(this.repo.existsById(key)) {
			this.repo.deleteById(key);
		}else {
			throw new RuntimeException("element not found");
		}
	}
	
	public int updateAmount(int id,double amount){
		return this.repo.updateAmountById(id,amount);
	}
	
	public List<Product> findByRatePerUnit(double amount){
		return this.repo.findRateGreatorThan(amount);
	}

}
