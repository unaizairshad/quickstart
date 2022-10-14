package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringJdbcApplication.class, args);
		
		//int key=1 -- to insert new
		int key=2;  // to display all inserted
		
		CustomerService service = ctx.getBean(CustomerService.class);
		
		if(key==1) { 
		
		Customer obj = ctx.getBean(Customer.class);
		//obj => {0,null,null}
		obj.setCustomerId(Integer.parseInt(args[0]));
		obj.setCustomerName(args[1]);
		obj.setEmail(args[2]);
		//obj => {101,"ramesh","ramesh@abc.com"
		
		//CustomerService service = ctx.getBean(CustomerService.class);
		
		System.out.println("Is Added := " +service.save(obj));
		}
		
		if(key==2) {
			service.findAll().forEach(System.out::println);
		}
		ctx.close();

	
	}

}
