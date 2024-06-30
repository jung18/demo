package com.example.demo.introduction.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Section {

    private Long id;
    private Long introductionId;
    private String subTitle;
    private String content;

    public Section(String subTitle, String content) {
        this.subTitle = subTitle;
        this.content = content;
    }
}
