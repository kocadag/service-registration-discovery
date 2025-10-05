package com.bekirkocadag.microservice.eurekadiscoveryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class EurekadiscoveryclientApplication {

    private final RestTemplate restTemplate;

    public EurekadiscoveryclientApplication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekadiscoveryclientApplication.class, args);
    }

    @GetMapping("/call-client")
    public String callClient() {
        return restTemplate.getForObject("http://client-service/hello", String.class);
    }
}