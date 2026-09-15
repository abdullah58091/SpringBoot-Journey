package com.example.myfirstProject.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    private String name;

    private Main main;

    private List<Weather> weather;

    @Getter
    @Setter
    public static class Main {

        private double temp;

        @JsonProperty("feels_like")
        private double feelsLike;

        private int humidity;
    }

    @Getter
    @Setter
    public static class Weather {

        private String description;
    }
}