package com.microservice.institute.service;

import com.microservice.institute.model.dto.InstituteDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface InstituteService {
  Flux<InstituteDto> findAll();
  Mono<InstituteDto> findById(String id);
  Mono<InstituteDto> create(InstituteDto institute);
  Mono<InstituteDto> update(InstituteDto institute, String id);
  Mono<Void> delete(String id);
}
