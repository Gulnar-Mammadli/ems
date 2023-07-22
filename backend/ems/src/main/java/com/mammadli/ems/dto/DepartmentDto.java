package com.mammadli.ems.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDto {

    Long id;
    boolean active;
    String departmentName;
    String description;
    Set<EmployeeDto> employees;
}
