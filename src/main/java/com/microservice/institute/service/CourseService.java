package com.microservice.institute.service;

import com.microservice.institute.model.dto.CourseDto;
import reactor.core.publisher.Flux;

public interface CourseService {
  Flux<CourseDto> findByInstitute(String idInstitute);
}
