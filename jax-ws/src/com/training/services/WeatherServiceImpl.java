package com.training.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.training.ifaces.WeatherService;
import com.training.model.Weather;
import com.training.model.WeatherWrapper;

@WebService(endpointInterface = "com.training.ifaces.WeatherService")
public class WeatherServiceImpl implements WeatherService {

	@Override
	
	@WebMethod
	@WebResult(name = "current weather")
	public Weather getWeatherByCity(@WebParam(name = "cityName")String cityName) {
		// TODO Auto-generated method stub
		Weather weather = new Weather(cityName,32,27,60);
		if(cityName.equals("Pune")){
			weather= new Weather(cityName,27,23,50);
		}
		return weather;
	}
	
	@WebMethod
	public WeatherWrapper getWeatherByState(String stateName) {
		
		Weather chennai = new Weather("chennai",32,27,60);
		Weather madurai = new Weather("madurai",32,27,60);
		
		List<Weather> list = new ArrayList<Weather>();
		list.add(chennai);
		list.add(madurai);
		
		WeatherWrapper obj = new WeatherWrapper(list);
		
		return obj;
	}
	

}
