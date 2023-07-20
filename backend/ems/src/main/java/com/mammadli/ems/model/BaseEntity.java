package com.mammadli.ems.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
@NoArgsConstructor
@Data
@SuperBuilder(toBuilder=true)
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator", allocationSize = 1)
    Long id;

    @Column(name = "active",columnDefinition = "boolean default true")
    boolean active;
}
