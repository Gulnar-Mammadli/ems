package com.mammadli.ems.service;

import com.mammadli.ems.dto.EmployeeDto;
import com.mammadli.ems.exception.CustomException;
import com.mammadli.ems.mapper.EmployeeMapper;
import com.mammadli.ems.model.Employee;
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


    public EmployeeDto createEmployee(EmployeeDto dto) {
        Optional<Employee> response = employeeRepository.findByEmailAndActiveTrue(dto.getEmail());
        if(response.isPresent()){
            throw new CustomException("Email already exists");
        }
        Employee employee = employeeMapper.toEntity(dto);
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
        Employee updated = employeeRepository.save(employee);
        EmployeeDto employeeDto = employeeMapper.toDto(updated);
        return employeeDto;
    }

    public List<EmployeeDto> fetchAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.toDtos(employeeList);
    }
}
