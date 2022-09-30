package com.example.weatherproject.Controllers;

import com.example.weatherproject.Models.Country.CountryData;
import com.example.weatherproject.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping(value = "/countries")
public class CountriesController {
    @Autowired
    CountryService countryService;

    @GetMapping("/asia")
    @CrossOrigin(origins="http://localhost:3000")
    public Flux<CountryData> getCountries() {
            return countryService.getCountriesInAsia();
    }
}
