package com.mammadli.ems.mapper;

import com.mammadli.ems.dto.EmployeeDto;
import com.mammadli.ems.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper extends EntityMapper<Employee,EmployeeDto>{

}
