package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Restaurant;

public interface RestaurantRespository extends JpaRepository<Restaurant, Integer> {
	
	//findByPropertyName =>Property Name first character
	public List<Restaurant> findByRestaurantName(String name);

	
	
	@Query(value = "select * from restaurant_sep_2022 where location=:loc",nativeQuery = true)
	public List<Restaurant> fetchUsingLocation(@Param("loc") String location);

	//JPQL => uses class name and propertyName
	@Query(value = "from Restaurant where rating=:reqRating")
	public List<Restaurant> fetchUsingRating(@Param("reqRating") double rating);

	//JPQL => uses class Name and Property Name
	@Modifying
	@Transactional
	@Query(value = "update Restaurant set rating=:newRating where restaurantId=:id")
	public int updateRating(@Param("id")int id,@Param("newRating")double revisedRating);

}
