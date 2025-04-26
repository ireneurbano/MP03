package com.example.api.service;

import com.example.api.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_KEY = "7dff048853bfae03cf74d21b8fc0e448";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s";

    public WeatherResponse getWeather(String city) {
        try {
            String url = String.format(BASE_URL, city, API_KEY);
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (Exception e) {
            System.err.println("Error al obtener el clima: " + e.getMessage());
            return null;
        }
    }
}
