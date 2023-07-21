package com.mammadli.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends BaseEntity implements Serializable {

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(name = "email", length = 254, unique = true, nullable = false)
    @EqualsAndHashCode.Include
    String email;

}
