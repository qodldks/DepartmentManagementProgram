package com.department.school.service;

import com.department.school.controller.dto.SaveStudentRequestDto;
import com.department.school.domain.Department;
import com.department.school.domain.Student;
import com.department.school.repository.DepartmentJpaRepository;
import com.department.school.repository.StudentJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentJpaRepository studentJpaRepository;
    private final DepartmentJpaRepository departmentJpaRepository;


    @Transactional
    public Long save(SaveStudentRequestDto requestDto) {
        // 학번 중복 입력 확인
        if(studentJpaRepository.findById(requestDto.getId()).isPresent()){
            throw new IllegalArgumentException("이미 등록된 학번입니다.");
        }

        // 학과 조회
        Department department = departmentJpaRepository
                .findById(requestDto.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학과입니다."));

        // 저장
        Student entity = requestDto.toEntity();
        entity.chooseDept(department);

        return studentJpaRepository.save(entity).getId();
    }
}
