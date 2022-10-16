package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductServices;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataJpaApplication.class, args);
		Product obj= ctx.getBean(Product.class);
		ProductServices service = ctx.getBean(ProductServices.class);
		//System.out.println("One Product with Following details added :="+service.save(obj));
		
		//service.findAll().forEach(System.out::println);  //findAll
		
		service.findByProductName("sony tv").forEach(System.out::println);
		ctx.close();
	}
	
	@Bean
	public Product tv() {
		return new Product(101,"sony tv",23000);
	}
	
	
}
