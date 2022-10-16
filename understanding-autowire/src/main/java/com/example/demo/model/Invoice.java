package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data


@Component
public class Invoice {
	Customer customer;
	Product product;
	
	//constructor DI
	public Invoice(@Qualifier("manju")Customer customer, Product product) {
		super();
		this.customer = customer;
		this.product = product;
	}
	

}
