package com.travel.weather.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.travel.weather.exception.WeatherDataNotFoundException;
import com.travel.weather.repository.WeatherData;
import com.travel.weather.repository.WeatherRepository;

@RestController
public class WeatherController {

	private final WeatherRepository repository;

	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	WeatherController(WeatherRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/weather/all")
	List<WeatherData> findAll() {
		return repository.findAll();
	}

	@PostMapping("/weather")
	ResponseEntity<WeatherData> newWeatherData(@RequestBody WeatherData newWeather) {
		if(!validate(newWeather)) {
			return new ResponseEntity<WeatherData>(HttpStatus.BAD_REQUEST);
		}
		if(repository.save(newWeather)) {
			return new ResponseEntity<WeatherData>(HttpStatus.CREATED);
		}
		return new ResponseEntity<WeatherData>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/weather")
	List<WeatherData> filterByDate(@RequestParam String date) {
		List<WeatherData> result = repository.findByDate(date);
		if(result.isEmpty()) {
			throw new WeatherDataNotFoundException(date);
		}
		return result;
	}

	@DeleteMapping("/weather")
	void deleteWeather() {
		repository.deleteAll();
	}
	
	public boolean validate(WeatherData weatherData) {
		if(weatherData == null) {
			return false;
		}
		if(weatherData.getTemperature().length > 24) {
			return false;
		}
		
        try {
            sdf.parse(weatherData.getDate());
        } catch (ParseException e) {
            return false;
        }
        
        return true;
	}
}
