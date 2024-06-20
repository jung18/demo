package com.example.demo.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SectionDto {

    private Long sectionId;
    private Long introductionId;
    private String subTitle;
    private String content;

}
