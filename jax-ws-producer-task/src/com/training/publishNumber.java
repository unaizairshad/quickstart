package com.training;

import javax.xml.ws.Endpoint;

import com.training.service.NumberToText;



public class publishNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Endpoint.publish("http://localhost:7070/number",new NumberToText());
		
		System.out.println("Service started");
		

	}

}
