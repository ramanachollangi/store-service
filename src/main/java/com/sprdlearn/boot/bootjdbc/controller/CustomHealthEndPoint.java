package com.sprdlearn.boot.bootjdbc.controller;

import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class CustomHealthEndPoint implements HealthIndicator {

    private final RestTemplate restTemplate;

    @Override
    public @Nullable Health health() {
        ResponseEntity<String> status= restTemplate.getForEntity("https://www.naukri.com/",String.class);
       if(status.getStatusCode().is2xxSuccessful()) {
           return Health.up().build();
       }
        return Health.down().build();
    }
}
