package com.example.myfirstProject.service;

import com.example.myfirstProject.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(String city) {

        URI finalAPI = UriComponentsBuilder
                .fromUriString(weatherApiUrl)
                .queryParam("access_key", apiKey)
                .queryParam("query", city)
                .build()
                .encode()
                .toUri();

        ResponseEntity<WeatherResponse> response =
                restTemplate.exchange(
                        finalAPI,
                        HttpMethod.GET,
                        null,
                        WeatherResponse.class
                );

        return response.getBody();
    }
}