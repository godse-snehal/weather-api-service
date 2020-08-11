package com.travel.weather.exception;

public class WeatherDataNotFoundException extends RuntimeException {

	public WeatherDataNotFoundException(String date) {
	    super("Could not find weather for given date " + date);
	  }
	}
