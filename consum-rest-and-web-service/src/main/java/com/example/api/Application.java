package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Esta anotación indica que esta clase es la clase principal de Spring Boot
public class Application {

    public static void main(String[] args) {
        // Lanza la aplicación de Spring Boot
        SpringApplication.run(Application.class, args);
    }
}
