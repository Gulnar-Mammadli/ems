package com.mammadli.ems.controller;

import com.mammadli.ems.dto.DepartmentDto;
import com.mammadli.ems.service.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/departments")
@RequiredArgsConstructor
@Tag(name = "Department",description = "Department management APIs")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok().body(departmentService.create(departmentDto));
    }

    @PatchMapping
    public ResponseEntity<DepartmentDto> partialUpdate(@Valid @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok().body(departmentService.partialUpdate(departmentDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> fetchById(@PathVariable Long id){
        return ResponseEntity.ok().body(departmentService.fetchById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id ){
        return ResponseEntity.ok().body(departmentService.delete(id));
    }
}
