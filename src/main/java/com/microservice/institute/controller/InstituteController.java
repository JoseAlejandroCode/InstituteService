package com.microservice.institute.controller;

import com.microservice.institute.model.dto.InstituteDto;
import com.microservice.institute.service.InstituteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;

@Api(value="institutes", description="Operations pertaining to institutes")
@RestController
@RequestMapping("/api/institutes")
public class InstituteController {

  @Autowired
  private InstituteService instituteService;

  @ApiOperation(value = "View a list of available institutes", response = InstituteDto.class)
  @GetMapping
  public Mono<ResponseEntity<Flux<InstituteDto>>> findAll(){
    return Mono.just(ResponseEntity
            .ok().contentType(MediaType.APPLICATION_JSON).body(instituteService.findAll()));
  }

  @ApiOperation(value = "View a institute by ID", response = InstituteDto.class)
  @GetMapping("/{id}")
  public Mono<ResponseEntity<InstituteDto>> finById(@PathVariable String id){
    return instituteService.findById(id)
            .map(institute -> ResponseEntity
            .ok().contentType(MediaType.APPLICATION_JSON).body(institute));
  }

  @ApiOperation(value = "Save a institute", response = InstituteDto.class)
  @PostMapping
  public  Mono<ResponseEntity<InstituteDto>> save(@Valid @RequestBody InstituteDto institute) {
    return instituteService.create(institute)
            .map(s -> ResponseEntity
            .created(URI.create("/api/institutes")).contentType(MediaType.APPLICATION_JSON).body(s));
  }

  @ApiOperation(value = "Update a institute", response = InstituteDto.class)
  @PutMapping("/{id}")
  public Mono<ResponseEntity<InstituteDto>> update(@RequestBody InstituteDto institute, @PathVariable String id){
    return instituteService.update(institute, id)
            .map(s -> ResponseEntity
                .created(URI.create("/api/institutes")).contentType(MediaType.APPLICATION_JSON).body(s));
  }

  @ApiOperation(value = "Delete of available institute", response = Mono.class)
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
    return instituteService.delete(id)
            .flatMap(p -> Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
  }

}
