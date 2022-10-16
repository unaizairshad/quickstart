package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;

@SpringBootApplication
public class SpringIbatisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(SpringIbatisApplication.class, args);
		
		Customer obj=ctx.getBean(Customer.class);
		obj.setCustomerId(105);
		obj.setCustomerName("amar");
		obj.setEmail("amar@gmail.com");
		
		
		CustomerService service =ctx.getBean(CustomerService.class);
		System.out.println("Is added :="+service.save(obj));
		service.findAll().forEach(System.out::println);
		
		//ctx.getBean(CustomerService.class).findAll().forEach(System.out::println);
		ctx.close();
		
	}

}
