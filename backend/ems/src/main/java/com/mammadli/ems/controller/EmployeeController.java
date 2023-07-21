package com.mammadli.ems.controller;

import com.mammadli.ems.dto.EmployeeDto;
import com.mammadli.ems.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Tag(name = "Employee",description = "Employee management APIs")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Create a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created the employee",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})})
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto dto) {
        return ResponseEntity.ok().body(employeeService.createEmployee(dto));
    }

    @Operation(summary = "Fetch employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the employee",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})})
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> fetchById(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.fetchById(id));
    }

    @Operation(summary = "Fetch employee list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fetched successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})})
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> fetchAllEmployees() {
        return ResponseEntity.ok().body(employeeService.fetchAll());
    }

    @Operation(summary = "Delete employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the employee",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Long.class))})})
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.delete(id));
    }

    @Operation(summary = "Partial update employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Partially updated the employee",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})})
    @PatchMapping
    public ResponseEntity<EmployeeDto> partialUpdate(@Valid @RequestBody EmployeeDto dto) {
        return ResponseEntity.ok().body(employeeService.partialUpdate(dto));
    }
}
