package com.microservice.institute.repository;

import com.microservice.institute.model.document.Institute;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InstituteRepository extends ReactiveMongoRepository<Institute, String> {
}
