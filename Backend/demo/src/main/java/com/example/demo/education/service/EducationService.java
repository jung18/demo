package com.example.demo.education.service;

import com.example.demo.education.domain.Education;
import com.example.demo.education.repository.dto.EducationDto;
import com.example.demo.education.repository.EducationMapper;
import com.example.demo.exception.MyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationMapper educationMapper;

    public Long saveEducation(Education education) {
        educationMapper.saveEducation(education);
        return education.getId();
    }

    public void updateEducation(Long educationId, EducationDto updateParam) {
        Education findEducation = educationMapper.findByEducationId(educationId);

        if (!MyUtils.areAllFieldsNull(updateParam)) {
            if (findEducation == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 데이터");
            }
            educationMapper.updateEducation(educationId, updateParam);
        }
    }

    public EducationDto findById(Long educationId) {
        Education findEducation = educationMapper.findByEducationId(educationId);

        if (findEducation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 데이터");
        }

        return new EducationDto(findEducation.getId(), findEducation.getUniversityName(),
                                findEducation.getDegree(), findEducation.getMajor(),
                                findEducation.getStartDate(), findEducation.getGraduateDate());
    }

    public void deleteEducation(Long educationId) {
        educationMapper.deleteEducation(educationId);
    }

}
