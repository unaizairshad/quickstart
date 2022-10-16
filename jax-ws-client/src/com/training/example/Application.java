package com.training.example;


public class Application {
	public static void main(String[] args) {
		
		WeatherService service = new WeatherServiceImplService().getWeatherServiceImplPort();
		
		WeatherWrapper weather = service.getWeatherByState("chennai");
		
		weather.getList().forEach(System.out::println);
		
		System.out.println(service.getWeatherByCity("Pune"));
		
		
	}

}



