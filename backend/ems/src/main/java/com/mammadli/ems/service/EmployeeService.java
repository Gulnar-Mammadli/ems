package com.mammadli.ems.service;

import com.mammadli.ems.dto.EmployeeDto;
import com.mammadli.ems.exception.CustomException;
import com.mammadli.ems.mapper.EmployeeMapper;
import com.mammadli.ems.model.Department;
import com.mammadli.ems.model.Employee;
import com.mammadli.ems.repository.DepartmentRepository;
import com.mammadli.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    private final DepartmentRepository departmentRepository;


    public EmployeeDto createEmployee(EmployeeDto dto) {
        Optional<Employee> response = employeeRepository.findByEmailAndActiveTrue(dto.getEmail());
        Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new CustomException("Department#" + dto.getDepartment() + " not found"));
        if (response.isPresent()) {
            throw new CustomException("Email already exists");
        }
        Employee employee = employeeMapper.toEntity(dto);
        employee.setDepartment(department);
        employee.setActive(true);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    public EmployeeDto fetchById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new CustomException("Employee#" + id + " not found"));
        return employeeMapper.toDto(employee);
    }

    public Long delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new CustomException("Employee#" + id + " not found"));
        employeeRepository.delete(employee);
        return id;
    }

    public EmployeeDto partialUpdate(EmployeeDto dto) {
        Employee employee = employeeRepository.findById(dto.getId()).orElseThrow(() -> new CustomException("Employee#" + dto.getId() + " not found"));
        employeeMapper.partialUpdate(employee, dto);
        employee.setActive(true);
        if (dto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new CustomException("Department#" + dto.getId() + " not found"));
            employee.setDepartment(department);
        }
        Employee updated = employeeRepository.save(employee);
        return employeeMapper.toDto(updated);
    }

    public List<EmployeeDto> fetchAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.toDtos(employeeList);
    }
}
