package com.department.school.controller;

import com.department.school.controller.dto.SaveDepartmentRequestDto;
import com.department.school.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/api/departments")
    public Long createDept(@RequestBody SaveDepartmentRequestDto requestDto){
        return departmentService.save(requestDto);
    }
}
