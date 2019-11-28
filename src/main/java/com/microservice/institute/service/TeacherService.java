package com.microservice.institute.service;

import com.microservice.institute.model.dto.TeacherDto;
import reactor.core.publisher.Flux;

public interface TeacherService {
  Flux<TeacherDto> findByInstitute(String idInstitute);
}
