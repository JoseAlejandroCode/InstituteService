package com.microservice.institute.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceConfig {

  @Value("${config.base.service.uri}")
  private String pathService;

  @Bean
  public WebClient registrarWebClient() {
    return WebClient.create(pathService);
  }

}
