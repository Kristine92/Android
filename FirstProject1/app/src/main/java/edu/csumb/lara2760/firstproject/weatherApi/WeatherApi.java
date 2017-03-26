package edu.csumb.lara2760.firstproject.weatherApi;

import edu.csumb.lara2760.firstproject.data.weatherData.Weather;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by andrade on 3/25/17.
 */

/*

http://api.openweathermap.org/data/2.5/weather?appid=9dd263d0405171a8127527ff014f258a&q=Salinas
 */

public interface WeatherApi {
    @GET("data/2.5/weather")
    rx.Observable<Weather> getWeather(
            @Query("appid") String appid,
            @Query("q") String cityName);
}
