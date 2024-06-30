package com.example.demo.introduction.service;

import com.example.demo.introduction.domain.Introduction;
import com.example.demo.introduction.domain.Section;
import com.example.demo.introduction.repository.dto.IntroductionListDto;
import com.example.demo.introduction.repository.IntroductionMapper;
import com.example.demo.introduction.repository.dto.IntroductionDto;
import com.example.demo.introduction.repository.dto.SectionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        Introduction findIntroduction = introductionMapper.findByIntroductionId(introductionId);

        if (findIntroduction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 데이터");
        }

        Introduction introduction = new Introduction(updateParam.getTitle());
        introductionMapper.updateIntroduction(introductionId, introduction);

        List<Section> sections = updateParam.getSections().stream()
                .map(sectionDto -> new Section(sectionDto.getId(), sectionDto.getIntroductionId(), sectionDto.getSubTitle(), sectionDto.getContent()))
                .collect(Collectors.toList());
        for (Section section : sections) {
            introductionMapper.updateSection(section.getId(), section);
        }
        return introductionId;
    }

    public IntroductionDto findById(Long id) {
        Introduction findIntroduction = introductionMapper.findByIntroductionId(id);

        if (findIntroduction == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 데이터");
        }

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
