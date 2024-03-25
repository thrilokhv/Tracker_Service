package com.tractive.trackerservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.build();
    }
}
