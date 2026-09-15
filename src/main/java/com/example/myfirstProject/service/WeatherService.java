package com.example.myfirstProject.service;


import com.example.myfirstProject.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    @Autowired
    private RestTemplate restTemplate;
/*
    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

 */

    public WeatherResponse getWeather(String city) {

        String finalAPI = weatherApiUrl.replace("{city}", city).replace("{apiKey}", apiKey);

        ResponseEntity<WeatherResponse> response =
                restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);

        return response.getBody();
    }
}

