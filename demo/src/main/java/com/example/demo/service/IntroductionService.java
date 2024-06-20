package com.example.demo.service;

import com.example.demo.domain.Introduction;
import com.example.demo.domain.Section;
import com.example.demo.repository.IntroductionListDto;
import com.example.demo.repository.IntroductionMapper;
import com.example.demo.repository.IntroductionDto;
import com.example.demo.repository.SectionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class IntroductionService {

    private final IntroductionMapper introductionMapper;

    public Introduction saveIntroduction(Introduction introduction, List<Section> sections) {
        introductionMapper.saveIntroduction(introduction);
        introductionMapper.saveSections(introduction.getId(), sections);
        return introduction;
    }

    public Long updateIntroduction(Long introductionId, IntroductionDto updateParam) {
        Introduction introduction = new Introduction(updateParam.getTitle());
        introductionMapper.updateIntroduction(introductionId, introduction);

        List<Section> sections = updateParam.getSections().stream()
                .map(sectionDto -> new Section(sectionDto.getSectionId(), sectionDto.getIntroductionId(), sectionDto.getSubTitle(), sectionDto.getContent()))
                .collect(Collectors.toList());
        for (Section section : sections) {
            introductionMapper.updateSection(section.getId(), section);
        }
        return introductionId;
    }

    public IntroductionDto findById(Long id) {
        Introduction findIntroduction = introductionMapper.findByIntroductionId(id);
        List<SectionDto> collect = introductionMapper.findAllSection(id).stream()
                .map(section -> new SectionDto(section.getId(), section.getIntroductionId(), section.getSubTitle(), section.getContent()))
                .collect(Collectors.toList());
        return new IntroductionDto(findIntroduction.getId(), findIntroduction.getTitle(), collect);
    }

    public List<IntroductionListDto> findMyIntroductions(Long userId) {
        return introductionMapper.findAllIntroduction(userId).stream()
                .map(introduction -> new IntroductionListDto(introduction.getId(), introduction.getTitle()))
                .collect(Collectors.toList());
    }

    public void deleteIntroduction(Long id) {
        introductionMapper.deleteIntroduction(id);
    }

    public void deleteSection(Long id) {
        introductionMapper.deleteSection(id);
    }
}
