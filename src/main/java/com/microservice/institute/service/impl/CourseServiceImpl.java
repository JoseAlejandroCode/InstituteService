package com.microservice.institute.service.impl;

import com.microservice.institute.model.dto.CourseDto;
import com.microservice.institute.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private WebClient webClient;

  @Override
  public Flux<CourseDto> findByInstitute(String idInstitute) {
    return webClient.get()
            .uri("/api/teachers/institute/{idInstitute}", Collections.singletonMap("idInstitute", idInstitute))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(CourseDto.class);
  }
}
