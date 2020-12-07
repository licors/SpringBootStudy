package com.example.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringbootrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootrestApplication.class, args);
    }

    // 전역설정
    @Bean
    public WebClientCustomizer webClientCustomizer() {
        return new WebClientCustomizer() {
            @Override
            public void customize(WebClient.Builder webClientBuilder) {
                webClientBuilder.baseUrl("http://localhost:8080");
            }
        };
    }


    // apach httpClient 로 변경하기 (의존성 추가 필요)
    @Bean
    public RestTemplateCustomizer restTemplateCustomizer() {
        return new RestTemplateCustomizer() {
            @Override
            public void customize(RestTemplate restTemplate) {
                restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
            }
        };
    }

}
