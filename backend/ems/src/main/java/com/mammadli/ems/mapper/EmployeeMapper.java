package com.mammadli.ems.mapper;

import com.mammadli.ems.dto.EmployeeDto;
import com.mammadli.ems.model.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = DepartmentMapper.class)
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeDto> {

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EmployeeDto toDto(Employee entity);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee toEntity(EmployeeDto dto);
}
