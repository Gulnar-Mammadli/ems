package com.mammadli.ems.mapper;

import com.mammadli.ems.dto.DepartmentDto;
import com.mammadli.ems.model.Department;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = EntityMapper.class)
public interface DepartmentMapper extends EntityMapper<Department, DepartmentDto> {

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "employees", ignore = true)
    DepartmentDto toDto(Department entity);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentDto dto);
}
