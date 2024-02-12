package com.evocoding.employeemanagementsystem.mapper;
import com.evocoding.employeemanagementsystem.dto.CreatedEmployeeDTO;
import com.evocoding.employeemanagementsystem.dto.EmployeeDTO;
import com.evocoding.employeemanagementsystem.dto.UpdateEmpolyeeDTO;
import com.evocoding.employeemanagementsystem.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface EmployeeMapper {

    EmployeeDTO maptoEmpoleeDTO(EmployeeEntity employeeEntity);
    EmployeeEntity maptoEmployeeEntity(CreatedEmployeeDTO createdEmployeeDTO);

    void maptoEmployeeEntity(UpdateEmpolyeeDTO updateEmpolyeeDTO,@MappingTarget EmployeeEntity employee);

    List<EmployeeDTO> maptoEmployeeDTOList(List<EmployeeEntity> employeeEntities);






}
