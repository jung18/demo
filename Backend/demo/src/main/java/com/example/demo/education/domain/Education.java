package com.example.demo.education.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class Education {

    private Long id;
    private Long userId;
    private String universityName;
    private String degree;
    private String major;
    private LocalDate startDate;
    private LocalDate graduateDate;

    public Education(Long userId, String universityName, String degree, String major, LocalDate startDate, LocalDate graduateDate) {
        this.userId = userId;
        this.universityName = universityName;
        this.degree = degree;
        this.major = major;
        this.startDate = startDate;
        this.graduateDate = graduateDate;
    }
}
