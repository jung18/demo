package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// 임시 파일
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // index.html 파일을 반환합니다.
    }
}
