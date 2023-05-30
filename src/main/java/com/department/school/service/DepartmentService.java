package com.department.school.service;

import com.department.school.controller.dto.SaveDepartmentRequestDto;
import com.department.school.repository.DepartmentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentJpaRepository departmentJpaRepository;

    @Transactional
    public Long save(SaveDepartmentRequestDto requestDto) {
        // 1. 학과 이름 체크
        if (departmentJpaRepository.findByName(requestDto.getName()).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 학과입니다.");
        }
        return departmentJpaRepository.save(requestDto.toEntity()).getId();
    }
}
