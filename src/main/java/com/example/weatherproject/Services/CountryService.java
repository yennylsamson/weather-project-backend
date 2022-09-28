package com.example.weatherproject.Services;

import com.example.weatherproject.Models.Country.CountryData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CountryService {
    @Autowired
    WebClient webClient;

    private static final Logger logger = LogManager.getLogger(CountryService.class);

    public Flux<CountryData> getCountriesInAsia() {
        return webClient.get()
                .uri("https://restcountries.com/v3.1/region/asia")
                .retrieve()
                .bodyToFlux(CountryData.class)
                .doOnError(throwable -> logger.error("Failed for some reason", throwable));
    }
}
