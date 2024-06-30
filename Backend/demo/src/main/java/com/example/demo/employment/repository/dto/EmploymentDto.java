package com.example.demo.employment.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EmploymentDto {

    private Long id;
    private String companyName;
    private String position;
    private String department;
    private LocalDate startDate;
    private LocalDate endDate;
    private String achievement;

}
