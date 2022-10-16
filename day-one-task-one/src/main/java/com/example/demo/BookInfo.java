package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
//@NoArgsConstructor

@Data

@Component
public class BookInfo {
	Book book;
	Publisher publisher;
	
	@Autowired
	public BookInfo(Book book, Publisher publisher) {
		super();
		this.book = book;
		this.publisher = publisher;
	}
	
	

}
