package com.example.demo.introduction.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class IntroductionDto {

    private Long id;
    private String title;
    private List<SectionDto> sections;

}
