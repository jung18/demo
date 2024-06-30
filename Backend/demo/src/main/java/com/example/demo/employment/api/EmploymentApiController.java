package com.example.demo.employment.api;

import com.example.demo.employment.domain.Employment;
import com.example.demo.employment.repository.dto.EmploymentDto;
import com.example.demo.employment.service.EmploymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmploymentApiController {

    private final EmploymentService EmploymentService;

    @PostMapping("/api/employment")
    public CreateEmploymentResponse createEmployment(@Valid @RequestBody CreateEmploymentRequest request) {
        Employment Employment = new Employment(request.getUserId(), request.getCompanyName(), request.getPosition(),
                                            request.getDepartment(), request.getStartDate(), request.getEndDate(), request.getAchievement());
        Employment result = EmploymentService.saveEmployment(Employment);
        return new CreateEmploymentResponse(result.getId());
    }

    @PutMapping("/api/employment/{id}")
    public Long updateEmployment(@PathVariable("id") Long id, @Valid @RequestBody EmploymentDto updateParam) {
        return EmploymentService.updateEmployment(id, updateParam);
    }

    @GetMapping("/api/employment/{id}")
    public EmploymentDto findById(@PathVariable("id") Long id) {
        return EmploymentService.findById(id);
    }

    @DeleteMapping("/api/employment/{id}")
    public void deleteEmployment(@PathVariable("id") Long id) {
        EmploymentService.deleteEmployment(id);
    }

    @Getter
    static class CreateEmploymentRequest {
        @NotNull
        private Long userId;
        @NotNull
        private String companyName;
        @NotNull
        private String position;
        private String department;
        @NotNull
        private LocalDate startDate;
        private LocalDate endDate;
        private String achievement;
    }

    @Getter
    @AllArgsConstructor
    static class CreateEmploymentResponse {
        private Long id;
    }

}
