package com.example.demo.education.repository;

import com.example.demo.education.domain.Education;
import com.example.demo.education.repository.dto.EducationDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface EducationMapper {

    void saveEducation(Education education);

    void updateEducation(@Param("id") Long id, @Param("updateParam") EducationDto updateParam);

    void deleteEducation(Long id);

    Education findByEducationId(Long id);
    
}
