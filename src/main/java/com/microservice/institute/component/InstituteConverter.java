package com.microservice.institute.component;

import com.microservice.institute.model.document.Institute;
import com.microservice.institute.model.dto.InstituteDto;
import org.springframework.stereotype.Component;

@Component
public class InstituteConverter {

  public InstituteDto convertToDto(Institute institute){
    InstituteDto instituteDto = new InstituteDto();
    instituteDto.setId(institute.getId());
    instituteDto.setName(institute.getName());
    return instituteDto;
  }

  public Institute convertToDocument(InstituteDto instituteDTO){
    Institute institute = new Institute();
    institute.setId(instituteDTO.getId());
    institute.setName(instituteDTO.getName());
    return institute;
  }

}
