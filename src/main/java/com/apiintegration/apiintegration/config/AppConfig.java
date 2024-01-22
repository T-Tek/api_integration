package com.apiintegration.apiintegration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Value("${BASE_URL}")
    private String BASE_URL;

    @Bean
    RestClient restClient(){
        return RestClient.create(BASE_URL);
    }
}
