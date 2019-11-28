package com.microservice.institute.service.impl;

import com.microservice.institute.model.dto.TeacherDto;
import com.microservice.institute.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;

@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  private WebClient webClient;

  @Override
  public Flux<TeacherDto> findByInstitute(String idInstitute) {
    return webClient.get()
            .uri("/api/teachers/institute/{idInstitute}", Collections.singletonMap("idInstitute", idInstitute))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(TeacherDto.class);
  }
}
