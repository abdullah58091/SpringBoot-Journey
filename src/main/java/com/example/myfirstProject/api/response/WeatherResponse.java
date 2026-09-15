package com.example.myfirstProject.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {

    private Location location;
    private Current current;

    @Getter
    @Setter
    public static class Location {
        private String name;
        private String country;
    }

    @Getter
    @Setter
    public static class Current {
        private double temperature;
        private double feelslike;
        private int humidity;
        private List<String> weather_descriptions;
    }
}