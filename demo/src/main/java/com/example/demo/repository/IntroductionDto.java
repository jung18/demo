package com.example.demo.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class IntroductionDto {

    private Long introductionId;
    private String title;
    private List<SectionDto> sections;

}
