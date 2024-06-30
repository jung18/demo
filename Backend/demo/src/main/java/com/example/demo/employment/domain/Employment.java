package com.example.demo.employment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class Employment {

    private Long id;
    private Long userId;
    private String companyName;
    private String position;
    private String department;
    private LocalDate startDate;
    private LocalDate endDate;
    private String achievement;

    public Employment(Long userId, String companyName, String position, String department, LocalDate startDate, LocalDate endDate, String achievement) {
        this.userId = userId;
        this.companyName = companyName;
        this.position = position;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.achievement = achievement;
    }
}
