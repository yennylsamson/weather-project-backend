package com.example.weatherproject.Services;
import com.example.weatherproject.Models.Weather.WeatherData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WeatherService {
    @Autowired
    WebClient webClient;

    private static final Logger logger = LogManager.getLogger(WeatherService.class);

    public Flux<WeatherData> getWeatherInACountry(String country){
        return webClient.get()
                .uri("https://api.openweathermap.org/data/2.5/weather?q="+country+"&APPID=0193b5d33ca87ec43b479e3ac7667f48&units=metric&units=metric")
                .retrieve()
                .bodyToFlux(WeatherData.class)
                .doOnError(throwable -> logger.error("Failed for some reason", throwable));
    }
}
