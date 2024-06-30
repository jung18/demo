package com.example.demo.employment.service;

import com.example.demo.employment.domain.Employment;
import com.example.demo.employment.repository.EmploymentMapper;
import com.example.demo.employment.repository.dto.EmploymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmploymentService {

    private final EmploymentMapper EmploymentMapper;

    public Employment saveEmployment(Employment Employment) {
        EmploymentMapper.saveEmployment(Employment);
        return Employment;
    }

    public Long updateEmployment(Long EmploymentId, EmploymentDto updateParam) {
        Employment findEmployment = EmploymentMapper.findByEmploymentId(EmploymentId);

        if (findEmployment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 데이터");
        }

        EmploymentMapper.updateEmployment(EmploymentId, updateParam);
        return EmploymentId;
    }

    public EmploymentDto findById(Long EmploymentId) {
        Employment findEmployment = EmploymentMapper.findByEmploymentId(EmploymentId);

        if (findEmployment == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 데이터");
        }

        return new EmploymentDto(findEmployment.getId(), findEmployment.getCompanyName(), findEmployment.getPosition(),
                                findEmployment.getDepartment(), findEmployment.getStartDate(), findEmployment.getEndDate(),
                                findEmployment.getAchievement());
    }

    public void deleteEmployment(Long EmploymentId) {
        EmploymentMapper.deleteEmployment(EmploymentId);
    }

}
