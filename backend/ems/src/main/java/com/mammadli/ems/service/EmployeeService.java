package com.mammadli.ems.service;

import com.mammadli.ems.dto.EmployeeDto;
import com.mammadli.ems.mapper.EmployeeMapper;
import com.mammadli.ems.model.Employee;
import com.mammadli.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        employee.setActive(true);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    public EmployeeDto fetchById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee#" + id + " not found"));
        return employeeMapper.toDto(employee);
    }

    public Long delete(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee#" + id + " not found"));
        employeeRepository.deleteById(id);
        return id;
    }

    public EmployeeDto partialUpdate(EmployeeDto dto) {
        Employee employee = employeeRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Employee#" + dto.getId() + " not found"));
        employeeMapper.partialUpdate(employee, dto);
        Employee updated = employeeRepository.save(employee);
        updated.setActive(true);
        EmployeeDto employeeDto = employeeMapper.toDto(employee);
        employeeDto.setActive(true);
        return employeeDto;
    }

    public List<EmployeeDto> fetchAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.toDtos(employeeList);
    }
}
