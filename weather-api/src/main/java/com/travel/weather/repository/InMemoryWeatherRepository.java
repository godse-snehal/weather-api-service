package com.travel.weather.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryWeatherRepository implements WeatherRepository {

	private Map<Integer, WeatherData> weatherDB = new HashMap<Integer, WeatherData>();

	/**
	 * Returns list of WeatherData objects in the database.
	 */
	@Override
	public List<WeatherData> findAll() {
		List<WeatherData> result = new ArrayList<WeatherData>();
		for (WeatherData d: weatherDB.values()) {
			result.add(d);
		}
		return result;
	}

	/**
	 * Saves the WeatherData object in database
	 * if database does not contain record with same id.
	 */
	@Override
	public boolean save(WeatherData data) {
		if (weatherDB.containsKey(data.getId())) {
			return false;
		}
		weatherDB.put(data.getId(), data);
		return true;
	}

	/**
	 * Deletes all the records in the database.
	 */
	@Override
	public boolean deleteAll() {
		weatherDB.clear();
		return true;

	}

	/**
	 * Finds records by date if exists.
	 */
	@Override
	public List<WeatherData> findByDate(String date) {
		List<WeatherData> result = new ArrayList<WeatherData>();
		for (WeatherData d : weatherDB.values()) {
			if (d.getDate().equals(date)) {
				result.add(d);
			}
		}
		return result;
	}

}
