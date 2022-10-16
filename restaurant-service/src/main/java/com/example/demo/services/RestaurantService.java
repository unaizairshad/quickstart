package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.ifaces.RestaurantRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantService {
	
	private RestaurantRespository repo;
	
	public Restaurant add(Restaurant entity) {
		return this.repo.save(entity);
	}
	
	public List<Restaurant> findAll(){
		return this.repo.findAll();
	}
	//2
	public Restaurant findById(int id) {
		String message= "Element with "+id+"Not found";
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException(message));
	}
	
	//5
	public List<Restaurant> findByName(String name) {
		return this.repo.findByRestaurantName(name);
	}
	
	//4
	public Restaurant update(Restaurant entity) {
		return this.repo.save(entity);
	}
	
	//3
	public Restaurant remove(int id) {
		Restaurant obj = findById(id);
		this.repo.deleteById(id);
		return obj;
		
	}
	
	
	//6
	public List<Restaurant> fetchUsingLocation(String location){
		return this.repo.fetchUsingLocation(location);
	}
	
	//7
	public List<Restaurant> fetchUsingRating(double rating){
		return this.repo.fetchUsingRating(rating);
	}
	
	//8
		public int updateRating(int id,double rating){
			return this.repo.updateRating(id, rating);
		}
	
}
