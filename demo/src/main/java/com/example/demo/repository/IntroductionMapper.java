package com.example.demo.repository;

import com.example.demo.domain.Introduction;
import com.example.demo.domain.Section;
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