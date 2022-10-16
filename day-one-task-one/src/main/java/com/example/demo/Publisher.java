package com.example.demo;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data

//@Component
public class Publisher {
	int publisherId;
	String publisherName;
	String location;

}
