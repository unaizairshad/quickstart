package com.example.demo.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByProductName(String qryString);
	
	//findByPropertyName -P should be capital
	//public List<Product> findByRatePerUnit(int rate);

	
	@Query(value = "update product_sep_2022 set rate_per_unit =:rate_per_unit where id=:id",nativeQuery = true)
	@Modifying
	@Transactional
	public int updateAmountById(@Param("id") int id,@Param("rate_per_unit") double amount);
	
	@Query(value = "select id,product_name,rate_per_unit from product_sep_2022 where rate_per_unit>=:srch",nativeQuery = true)
	public List<Product> findRateGreatorThan(@Param("srch") double amount);
	

	
	
	
}
