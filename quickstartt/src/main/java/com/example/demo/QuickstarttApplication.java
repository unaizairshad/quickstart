package com.example.demo;

import java.time.LocalDate;

import org.demo.module1.Address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import com.example.demo.model.Customer;
import com.example.demo.model.CustomerList;
import com.example.demo.model.Invoice;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.demo","org.demo.module1"})  //for importing address
public class QuickstarttApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(QuickstarttApplication.class, args);

		
		
		//1 //Customer ram = (Customer)ctx.getBean("customer");
		//System.out.println(ram);
		
		//Customer shyam = (Customer)ctx.getBean("shyam");  //casting is required
		//System.out.println(shyam);
		
		//2  /*Customer ram = (Customer)ctx.getBean(Customer.class);
		//		System.out.println(ram);
		
		//3
		Customer ram = ctx.getBean("customer",Customer.class);  //casting not required
		System.out.println(ram);
		
		Customer shyam = ctx.getBean("shyam",Customer.class);
		System.out.println(shyam);
		
		
		
		System.out.println(ctx.getBean("shyamInvoice",Invoice.class));
		
		
		ctx.getBean(CustomerList.class).getCustList().forEach(System.out::println);//array list
		
		System.out.println(ctx.getBean(Address.class));  //address is in diff package
	}
	
	//factory method which will be invoked of IoC
	@Bean
	public Customer shyam() {
		return new Customer(202,"shyam kumar","shyam@abc.com");
	}
	
	
	@Bean
	public Customer vikas() {
		return new Customer(203,"vikas khanna","vikas@abc.com");
	}
	@Bean
	public Customer manju() {
		return new Customer(204,"manju nath","manju@abc.com");
	}
	
	
	@Bean
	public Invoice shyamInvoice() {
		return new Invoice(120,shyam(),LocalDate.of(22, 9, 2),56000);
	}

}
