package com.task;

public class Application {

	public static void main(String[] args) {
		
	CalculatorSoap service = new Calculator().getCalculatorSoap();
	
	System.out.println("Add result : "+service.add(2, 5));
	System.out.println("Add result : "+service.subtract(10, 5));
	System.out.println("Add result : "+service.multiply(2, 5));
	System.out.println("Add result : "+service.divide(20, 5));
	}
}
