package com.department.school.controller;

import com.department.school.controller.dto.SaveStudentRequestDto;
import com.department.school.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/api/students")
    public Long createStudent(@RequestBody SaveStudentRequestDto requestDto){
        return studentService.save(requestDto);
    }
}
