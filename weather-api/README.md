#Weather API service

To start the application run this command: mvn clean spring-boot:run

This will start the REST API service on port 8080. 

Supports following endpoints:

1. Save weather data : POST http://localhost:8080/weather
	<br/>Content-Type: application/json
	<br/>RequestBody : 
	{
        "id": 1,
        "date": "1985-01-01",
        "location": {
            "lat": 36.1189,
            "lon": -86.6892,
            "city": "Palo Alto",
            "state": "California"
        },
        "temperature": [
            37.3,
            36.8,
            36.4,
            36,
            35.6,
            35.3,
            35,
            34.9,
            35.8,
            38,
            40.2,
            42.3,
            43.8,
            44.9,
            45.5,
            45.7,
            44.9,
            43,
            41.7,
            40.8,
            39.9,
            39.2,
            38.6,
            38.1
        ]
    }
    
 2. To find all records: GET http://localhost:8080/weather/all
 
 3. To find by specific date : GET http://localhost:8080/weather?date=1985-01-01
 
 4. To delete all records : DELETE http://localhost:8080/weather





