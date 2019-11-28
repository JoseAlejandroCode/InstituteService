package com.microservice.institute.service.impl;

import com.microservice.institute.component.InstituteConverter;
import com.microservice.institute.model.dto.InstituteDto;
import com.microservice.institute.repository.InstituteRepository;
import com.microservice.institute.service.CourseService;
import com.microservice.institute.service.InstituteService;
import com.microservice.institute.service.StudentService;
import com.microservice.institute.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InstituteServiceImpl implements InstituteService {

  @Autowired
  private InstituteRepository instituteRepository;

  @Autowired
  private InstituteConverter instituteConverter;

  @Autowired
  private StudentService studentService;

  @Autowired
  private TeacherService teacherService;

  @Autowired
  private CourseService courseService;

  @Override
  public Flux<InstituteDto> findAll() {
    return instituteRepository.findAll()
            .flatMap(institute -> Mono.just(instituteConverter.convertToDto(institute)))
            .flatMap(institute ->  {
              institute.setStudents(studentService.findByInstitute(institute.getId()).collectList().block());
              institute.setCourses(courseService.findByInstitute(institute.getId()).collectList().block());
              institute.setTeachers(teacherService.findByInstitute(institute.getId()).collectList().block());
              return Mono.just(institute);
              }
            );
  }

  @Override
  public Mono<InstituteDto> findById(String id) {
    return instituteRepository.findById(id)
            .flatMap(institute -> Mono.just(instituteConverter.convertToDto(institute)))
            .flatMap(institute ->  {
                      institute.setStudents(studentService.findByInstitute(institute.getId()).collectList().block());
                      institute.setCourses(courseService.findByInstitute(institute.getId()).collectList().block());
                      institute.setTeachers(teacherService.findByInstitute(institute.getId()).collectList().block());
                      return Mono.just(institute);
                    }
            );
  }

  @Override
  public Mono<InstituteDto> create(InstituteDto institute) {
    return instituteRepository.save(instituteConverter.convertToDocument(institute))
            .flatMap(s -> Mono.just(instituteConverter.convertToDto(s)));
  }

  @Override
  public Mono<InstituteDto> update(InstituteDto institute, String id) {
    return findById(id).flatMap(i -> {
      i.setId(institute.getName());
      return instituteRepository.save(instituteConverter.convertToDocument(i))
              .flatMap(ins -> Mono.just(instituteConverter.convertToDto(ins)));
    });
  }

  @Override
  public Mono<Void> delete(String  id) {
    return findById(id)
              .flatMap(s -> instituteRepository.delete(instituteConverter.convertToDocument(s)));
  }

}
