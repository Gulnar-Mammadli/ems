package com.mammadli.ems.service;

import com.mammadli.ems.dto.DepartmentDto;
import com.mammadli.ems.exception.CustomException;
import com.mammadli.ems.mapper.DepartmentMapper;
import com.mammadli.ems.model.Department;
import com.mammadli.ems.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentDto create(DepartmentDto departmentDto) {
        Department department = departmentMapper.toEntity(departmentDto);
        department.setActive(true);
        return departmentMapper.toDto(departmentRepository.save(department));
    }

    public DepartmentDto partialUpdate(DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(departmentDto.getId()).orElseThrow(() -> new CustomException("Department#" + departmentDto.getId() + " not found"));
        departmentMapper.partialUpdate(department, departmentDto);
        department.setActive(true);
        return departmentMapper.toDto(departmentRepository.save(department));
    }

    public DepartmentDto fetchById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new CustomException("Department#" + id + " not found"));
        return departmentMapper.toDto(department);
    }

    public Long delete(Long id) {
        departmentRepository.findById(id).orElseThrow(() -> new CustomException("Department#" + id + " not found"));
        departmentRepository.deleteById(id);
        return id;
    }
}
