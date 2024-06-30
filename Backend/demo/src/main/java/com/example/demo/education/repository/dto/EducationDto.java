package com.example.demo.education.repository.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EducationDto {

    private Long id;
    private String universityName;
    private String degree;
    private String major;
    private LocalDate startDate;
    private LocalDate graduateDate;

}
