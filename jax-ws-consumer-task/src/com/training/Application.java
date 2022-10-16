package com.training;

public class Application {
public static void main(String[] args) {
		
		NumberToTextService service = new NumberToTextService_Service().getNumberToTextPort();
		
		System.out.println("Number 1 in string = "+service.numberToText(1));
		System.out.println("Number 2 = "+service.numberToText(2));
		System.out.println("Number 3 = "+service.numberToText(3));
		
	}

}
