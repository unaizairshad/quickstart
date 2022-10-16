package com.example.demo.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Fee;

public interface FeeRepository extends JpaRepository<Fee, Integer> {
	//the follewing method needs to follow DSL naming convection
	//public List<Fee> findByBranch(String srchString);
	
	//the following method need not follow DSL naming convections as
	//if u want to define your own name use @Query
	
	//@Query(value = "select * from tieto_fee where branch=:srchString",nativeQuery = true)
	//public List<Fee> findByBranchName(@Param("srchString")String srchString);
	
	//JPQL uses classname and PropertyNmae instead of TableName and ColumnName
	@Query(value = "From Fee where branch=:srchString",nativeQuery = false)
		public List<Fee> findByBranchName(@Param("srchString")String srchString);

	
	
	@Query(value = "update tieto_fee set amount=:revisedAmount where id=:id",nativeQuery = true)
	@Modifying
	@Transactional
	public int updateAmount(@Param("revisedAmount")double amount,@Param("id") int id);

}

