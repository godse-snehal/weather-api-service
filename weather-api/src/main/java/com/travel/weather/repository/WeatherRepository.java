package com.travel.weather.repository;

import java.util.List;

public interface WeatherRepository {
	
	List<WeatherData> findAll();
	
	boolean save(WeatherData data);
	
	boolean deleteAll();
	
	List<WeatherData> findByDate(String date);
	
	

}
