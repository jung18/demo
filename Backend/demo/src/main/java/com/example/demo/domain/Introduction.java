package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Introduction {

    private Long id;
    private Long userId;
    private String title;

    public Introduction(String title) {
        this.title = title;
    }

    public Introduction(Long userId, String title) {
        this.userId = userId;
        this.title = title;
    }
}
