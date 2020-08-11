package com.travel.weather.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InMemoryWeatherRepositoryTest {
	
	private InMemoryWeatherRepository inMemoryWeatherRepository;
	
	@BeforeEach
	public void init() {
		inMemoryWeatherRepository = new InMemoryWeatherRepository();
		
	}
	
	
	@Test
	public void testFindAll() {
		//Initialize WeatherData
		WeatherData weatherData1 = mockData(1, "2020-08-11");
		WeatherData weatherData2 = mockData(2, "2020-08-10");
		inMemoryWeatherRepository.save(weatherData1);
		inMemoryWeatherRepository.save(weatherData2);
		
		//Call findAll
		List<WeatherData> result = inMemoryWeatherRepository.findAll();
		
		//Check if return value as expected
		assertTrue(result.size() == 2);
	}
	
	
	@Test
	public void testSave() {
		
		assertTrue(inMemoryWeatherRepository.save(mockData(1, "2020-08-11")));

		assertTrue(inMemoryWeatherRepository.save(mockData(2, "2020-08-11")));
		
		//Same id so should not save
		assertFalse(inMemoryWeatherRepository.save(mockData(2, "2020-08-11")));
	}
	
	
	@Test
	public void testDeleteAll() {
		//Initialize WeatherData
		WeatherData weatherData1 = mockData(1, "2020-08-11");
		WeatherData weatherData2 = mockData(2, "2020-08-10");
		inMemoryWeatherRepository.save(weatherData1);
		inMemoryWeatherRepository.save(weatherData2);
				
				
		//Check if return value as expected
		assertTrue(inMemoryWeatherRepository.deleteAll());
		
	}
	
	@Test
	public void testFindByDate() {
		//Initialize WeatherData with specific date
		WeatherData weatherData1 = mockData(1, "2020-08-11");
		WeatherData weatherData2 = mockData(2, "2020-08-10");
		inMemoryWeatherRepository.save(weatherData1);
		inMemoryWeatherRepository.save(weatherData2);
		
		//Call findByDate with valid date
		List<WeatherData> result = inMemoryWeatherRepository.findByDate("2020-08-10");
		
		//Check if return value as expected
		assertTrue(result.size() == 1);
		assertEquals(weatherData2, result.get(0));
		
		//Call findByDate with invalid date
		result = inMemoryWeatherRepository.findByDate("2020-08-09");
				
		//Check if return value as expected
		assertTrue(result.size() == 0);
		
	}
	
	private WeatherData mockData(int id, String date) {
		WeatherData weatherData = new WeatherData();
		weatherData.setId(id);
		weatherData.setDate(date);
		weatherData.setTemperature(new float[]{3.0f, 4.0f, 5.0f});
		WeatherData.Location location = weatherData.new Location();
		location.setCity("San Francisco");
		location.setLat(100f);
		location.setLon(-300f);
		location.setState("CA");
		weatherData.setLocation(location);
		return weatherData;
	}
	

}
