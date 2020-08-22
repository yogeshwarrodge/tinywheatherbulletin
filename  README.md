Prerequesities

-> Java 8+
-> Spring Boot


About

Tiny weather bulletin is a weather forecast application used to check the weather conditions of the cities.
This service uses the OpenWeather API (​ https://openweathermap.org/api​ ) to retrieve the weather forecast.
Given a city name and the working hours it gives the average temperature and humidity inside and outside
working hours for the next three days.
The application contains following two Rest APi's

1. Fetch Data given city name.

URL for fetching data id:
[GET] http://localhost:8080/weather/forecast/{cityName}
It takes as an input city name and will return the weather forecast that is average temperature and humidity
for inside and outside working hours for next three days by using the city name provided and standard working hours
that is in between 10 AM to 6 PM.

How to run
To run the application, get a free API key from openweathermap.com and put it to file src/main/java/com.weather.forecast/config/Configuration.java file
You can run in following three ways:-


1. Clone the application from git and then run the application and use above two apis to get data

2. after run server hit the url http://localhost:8080/swagger-ui.html#/ hit the whether-controller get method try it now button and provide the city name and click on execute button for test api 
3. Run the bootJar task and the jar will be created user target folder.
You can also run the application using the jar file and use the API's to get data.


-> Command to run jar file: java -jar jarName

4. You can use Docker File located in the main folder.
First create the jar file using above command.
Then cd into the folder and run command "sudo docker build -t nameOfImage ." .
Image will be created in the docker and you can use the API's to get data.