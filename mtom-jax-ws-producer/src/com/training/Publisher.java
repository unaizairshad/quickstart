package com.training;

import javax.xml.ws.Endpoint;

import com.training.services.ImageProcessingImpl;

public class Publisher {
	
	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:7070/images",new ImageProcessingImpl());
		
		System.out.println("Image service started");
		
	}

}
