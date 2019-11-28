package com.microservice.institute.service;

import com.microservice.institute.model.dto.StudentDto;
import reactor.core.publisher.Flux;

public interface StudentService {
  Flux<StudentDto> findByInstitute(String idInstitute);
}
