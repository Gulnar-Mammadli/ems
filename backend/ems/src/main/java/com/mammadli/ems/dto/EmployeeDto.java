package com.mammadli.ems.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    Long id;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @NotNull
    String email;

    boolean active;
}
