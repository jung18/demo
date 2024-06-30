package com.example.demo.employment.repository;

import com.example.demo.employment.domain.Employment;
import com.example.demo.employment.repository.dto.EmploymentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface EmploymentMapper {

    void saveEmployment(Employment employment);

    void updateEmployment(@Param("id") Long id, @Param("updateParam") EmploymentDto updateParam);

    void deleteEmployment(Long id);

    Employment findByEmploymentId(Long id);
    
}
