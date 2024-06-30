package com.example.demo.introduction.repository;

import com.example.demo.introduction.domain.Introduction;
import com.example.demo.introduction.domain.Section;
import com.example.demo.introduction.repository.dto.IntroductionDto;
import com.example.demo.introduction.repository.dto.SectionDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IntroductionMapper {

    void saveIntroduction(Introduction introduction);

    void saveSections(@Param("introductionId") Long introductionId, @Param("sections") List<Section> sections);

    void updateIntroduction(@Param("id") Long id, @Param("updateParam") Introduction updateParam);

    void updateSection(@Param("id") Long id, @Param("updateParam") Section updateParam);

    void deleteIntroduction(Long id);

    void deleteSection(Long id);

    Introduction findByIntroductionId(Long id);

    List<Introduction> findAllIntroduction(Long userId);

    List<Section> findAllSection(Long introductionId);

}