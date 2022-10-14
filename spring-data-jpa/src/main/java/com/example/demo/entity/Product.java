package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity								//class
@Table(name="product_sep_2022")	//class to table mapping
public class Product {
	
	@Id
	int id;			//age,mark,salary,ammount
	//first_name,bill_amount
	
	@Column(name = "product_name",length = 40)
	String productName;
	@Column(name = "rate_per_unit")
	double ratePerUnit;

}
