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