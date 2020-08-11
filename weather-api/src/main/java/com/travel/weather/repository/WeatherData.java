package com.travel.weather.repository;

import java.util.Arrays;

public class WeatherData {

	private int id;
	private String date;
	private Location location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public float[] getTemperature() {
		return temperature;
	}

	public void setTemperature(float[] temperature) {
		this.temperature = temperature;
	}

	private float[] temperature;

	class Location {
		
		public Location() {
			
		}

		private float lat;
		private float lon;
		private String city;
		private String state;

		public float getLat() {
			return lat;
		}

		public void setLat(float lat) {
			this.lat = lat;
		}

		public float getLon() {
			return lon;
		}

		public void setLon(float lon) {
			this.lon = lon;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		private WeatherData getEnclosingInstance() {
			return WeatherData.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + Float.floatToIntBits(lat);
			result = prime * result + Float.floatToIntBits(lon);
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Location other = (Location) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
				return false;
			if (Float.floatToIntBits(lon) != Float.floatToIntBits(other.lon))
				return false;
			if (state == null) {
				if (other.state != null)
					return false;
			} else if (!state.equals(other.state))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Location [lat=" + lat + ", lon=" + lon + ", city=" + city + ", state=" + state + "]";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + Arrays.hashCode(temperature);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherData other = (WeatherData) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (!Arrays.equals(temperature, other.temperature))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WeatherData [id=" + id + ", date=" + date + ", location=" + location + ", temperature="
				+ Arrays.toString(temperature) + "]";
	}
}
