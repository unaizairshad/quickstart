package com.example.demo.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/product")
@AllArgsConstructor
public class ProductController {
	
	private ProductServices service;
	
	@GetMapping
	public List<Product> findAll(){
		return this.service.findAll();
	}
	
	
//	@GetMapping(path = "/byPrice")
//    public List<Product> findByRateGrtThan(@RequestParam("rate") double rate){
//        
//        return this.service.findByRatePerUnitGrtThan(rate);
//    }
	
	@PostMapping
	public ResponseEntity<Product> add(@RequestBody Product entity) throws URISyntaxException{
		
		Product added = this.service.save(entity);
		
		return  ResponseEntity.created(new URI("/api/v1/product/"))
				.body(added);
	}
	
	
	
	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable("id")int id) {
		this.service.deleteById(id);
		
//				orElseThrow(()->new RuntimeException("Element not found")); 
	}

	
	@PutMapping(path = "/{id}/{amount}")
	public ResponseEntity<String> update(@PathVariable("id") int id,@PathVariable("amount")double amount){
		
		int rowUpdated=this.service.updateAmount(id,amount);
		return ResponseEntity.ok().body("rowUpdated="+rowUpdated);
   
	}
	
	@GetMapping(path = "/key/{byPrice}")
    public List<Product> findByRateGrtThan(@PathVariable("byPrice") double rate){
        
        return this.service.findByRatePerUnit(rate);
    }
	 
	
}
