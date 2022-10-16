package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Invoice {
	int invoiceNumber;
	Customer customer;
	LocalDate invoiceDate;  //LocalDate is built in
	double price;
	

}
