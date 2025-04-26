package com.example.api.controller;

import com.example.api.model.WeatherResponse;
import com.example.api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String getWeather(@RequestParam(name = "city", required = false) String city, Model model) {
        if (city != null && !city.isEmpty()) {
            WeatherResponse response = weatherService.getWeather(city);
            if (response != null) {
                model.addAttribute("weather", response);
            } else {
                model.addAttribute("error", "No s'ha pogut obtenir el temps per a la ciutat indicada.");
            }
        }
        return "weather";
    }
}
