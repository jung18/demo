package com.example.demo.api;

import com.example.demo.domain.Introduction;
import com.example.demo.domain.Section;
import com.example.demo.repository.IntroductionDto;
import com.example.demo.repository.IntroductionListDto;
import com.example.demo.repository.SectionDto;
import com.example.demo.service.IntroductionService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class IntroductionApiController {

    private final IntroductionService introductionService;

    @PostMapping("/api/introduction")
    public CreateIntroductionResponse saveIntroduction(@RequestBody CreateIntroductionRequest request) {
        Introduction introduction = new Introduction(request.getUserId(), request.getTitle());
        List<CreateSectionRequest> sections = request.getSections();

        List<Section> collect = sections.stream()
                .map(section -> new Section(section.getSubTitle(), section.getContent()))
                .collect(Collectors.toList());
        Introduction result = introductionService.saveIntroduction(introduction, collect);

        return new CreateIntroductionResponse(result.getId());
    }

    @PutMapping("/api/introduction/{id}")
    public Long updateIntroduction(@PathVariable("id") Long id, @RequestBody IntroductionDto updateParam) {
        return introductionService.updateIntroduction(id, updateParam);
    }

    @GetMapping("/api/introduction/{id}")
    public IntroductionDto findById(@PathVariable("id") Long id) {
        return introductionService.findById(id);
    }

    @GetMapping("/api/introductions/{userId}")
    public MyIntroductionList findMyIntroductions(@PathVariable("userId") Long userId) {
        List<IntroductionListDto> myIntroductions = introductionService.findMyIntroductions(userId);
        return new MyIntroductionList(myIntroductions);
    }


    @DeleteMapping("/api/introduction/{id}")
    public void deleteIntroduction(@PathVariable("id") Long id) {
        introductionService.deleteIntroduction(id);
    }

    @DeleteMapping("/api/introduction/section/{id}")
    public void deleteSection(@PathVariable("id") Long id) {
        introductionService.deleteSection(id);
    }

    @Getter
    static class CreateIntroductionRequest {
        private Long userId;
        private String title;
        private List<CreateSectionRequest> sections;
    }

    @Getter
    static class CreateSectionRequest {
        private String subTitle;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    static class CreateIntroductionResponse {
        private Long introductionId;
    }

    @Getter
    @AllArgsConstructor
    static class MyIntroductionList {
        private List<IntroductionListDto> results;
    }

}
