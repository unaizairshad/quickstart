package com.example.demo;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Fee;

@SpringBootApplication
public class SpringRestServiceClientApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx =SpringApplication.run(SpringRestServiceClientApplication.class, args);
	
	RestTemplate template =ctx.getBean(RestTemplate.class);
	
	String choice="post";
	
	String url="http://localhost:7070/api/v1/fees";
 
	if(choice.equals("get")) {
		Fee[] list= template.getForObject(url,Fee[].class);
	
		for(Fee eachItem: list) {
			System.out.println(eachItem);
		}
	}
	if(choice.equals("post")) {
		Map<String, Object> data = new HashMap<>();
			data.put("id", 105);
			data.put("branch", "M.C.A");
			data.put("year", "I year");
			data.put("amount",650000);
		
			 HttpHeaders header=new org.springframework.http.HttpHeaders();
	         header.setContentType(MediaType.APPLICATION_JSON);
	            
	         HttpEntity<Map<String,Object>> entity=new HttpEntity<>(data);
	            
	         ResponseEntity<Fee> resp=template.postForEntity(url, entity, Fee.class);
	            
	         System.out.println("Status code="+resp.getStatusCodeValue());
	         System.out.println("Element added="+resp.getBody());
	         System.out.println("Location of the newly created resource :="+resp.getHeaders().getFirst("location"));
	}
	
}
	@Bean
	public  RestTemplate template(){
		
		return new RestTemplate();
		}
}

