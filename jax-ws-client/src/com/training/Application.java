package com.training;

public class Application {
	public static void main(String[] args) {
		
		WeatherService service = new WeatherServiceImplService().getWeatherServiceImplPort();
		
		System.out.println("weather in pune :="+service.getWeatherByCity("Pune"));
		
		System.out.println("weather in udupi :="+service.getWeatherByCity("Udupi"));
		
		
	}

}
