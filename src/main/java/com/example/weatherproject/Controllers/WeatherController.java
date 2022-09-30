package com.example.weatherproject.Controllers;

import com.example.weatherproject.Models.Weather.WeatherData;
import com.example.weatherproject.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController{

    @Autowired
    WeatherService weatherService;

    @GetMapping("/current")
    @CrossOrigin(origins="http://localhost:3000")
    public Flux<WeatherData> getCountries(@RequestParam(value = "country")String country) {
            return weatherService.getWeatherInACountry(country);
    }
}
