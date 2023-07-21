package com.mammadli.ems.controller;

import com.mammadli.ems.dto.EmployeeDto;
import com.mammadli.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto dto) {
        return ResponseEntity.ok().body(employeeService.createEmployee(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> fetchById(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.fetchById(id));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> fetchAllEmployees() {
        return ResponseEntity.ok().body(employeeService.fetchAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.delete(id));
    }

    @PatchMapping
    public ResponseEntity<EmployeeDto> partialUpdate(@RequestBody EmployeeDto dto){
        return ResponseEntity.ok().body(employeeService.partialUpdate(dto));
    }
}
