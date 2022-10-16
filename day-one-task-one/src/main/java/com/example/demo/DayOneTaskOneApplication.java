package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DayOneTaskOneApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(DayOneTaskOneApplication.class, args);
		
		BookInfo obj = ctx.getBean(BookInfo.class);
		System.out.println(obj);
		
	}
	@Bean
	public Book java() {
		return new Book(100, "java","xyz", 780);
	}
	
	@Bean
	public Publisher publish() {
		return new Publisher(1,"abc","udupi");
	}
}
