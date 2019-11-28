package com.microservice.institute.service.impl;

import com.microservice.institute.model.dto.StudentDto;
import com.microservice.institute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private WebClient webClient;

  @Override
  public Flux<StudentDto> findByInstitute(String idInstitute) {
    return webClient.get()
            .uri("/api/students/institute/{idInstitute}", Collections.singletonMap("idInstitute", idInstitute))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(StudentDto.class);
  }
}
