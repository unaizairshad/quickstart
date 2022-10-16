package com.example.demo;

import java.time.LocalDate;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Restaurant;
import com.example.demo.ifaces.RestaurantRespository;
import com.example.demo.services.RestaurantService;

import lombok.AllArgsConstructor;

@SpringBootApplication
public class RestaurantServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(RestaurantServiceApplication.class, args);
		
		
		
		RestaurantService service=ctx.getBean(RestaurantService.class);
		
		int key=3;  //try 1 ,2,3
		switch (key) {
		case 1:
			service.findAll().forEach(System.out::println);
			break;
		case 2:
			System.out.println(service.findById(20303));
			break;
		case 3:
			System.out.println(service.remove(30303));
			break;
		case 4: 
			Restaurant objToUpdate = ctx.getBean("updateBean",Restaurant.class);
			System.out.println(service.update(objToUpdate));
			break;
		case 5:
			service.findByName("woodlands").forEach(System.out::println);
			break;
			
		case 6:
			service.fetchUsingLocation("chennai").forEach(System.out::println);
			break;
			
		case 7:
			service.fetchUsingRating(4.6).forEach(System.out::println);
			break;
		case 8:
			System.out.println(service.updateRating(30303,4.9));
			break;
			
		default:
			break;
		}
		
		
		//ctx.getBean(RestaurantService.class).findAll().forEach(System.out::println);
		
		//RestaurantService service=ctx.getBean(RestaurantService.class);
		//System.out.println(service.findById(20303));
		//System.out.println(service.findById(40303));//element with id 40303 not found
		ctx.close();
	}
	//2
	@Bean
	public Restaurant updateBean() {
		return new Restaurant(40303,"Geetham","chennai",4.6,LocalDate.of(2019, 10, 10));
	}
	
	
	//1
	@Bean
	public CommandLineRunner runner() {   //CommandLineRunner -build in
		return new CommandLineRunner() {    //annonymous class //right click > show in >System explorer>restaurant-service>target>classes>com>example>demo>--- u will find-->RestaurantServiceApplication$1.class  only when annonymous class is there 
			
			@Autowired
			RestaurantRespository repo;
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				//after inserting once comment this otherwise it will get inserted everytime u run
				repo.save(new Restaurant(20303,"Sangeetha","chennai",4.7,LocalDate.of(2022, 1, 1)));
				repo.save(new Restaurant(30303,"woodlands","mangalore",4.8,LocalDate.of(2022, 10, 10)));
				
					
			}
		};
	}

}
