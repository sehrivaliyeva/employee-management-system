package com.evocoding.employeemanagementsystem.service;

import com.evocoding.employeemanagementsystem.dto.CreatedEmployeeDTO;
import com.evocoding.employeemanagementsystem.dto.EmployeeDTO;
import com.evocoding.employeemanagementsystem.dto.UpdateEmpolyeeDTO;
import com.evocoding.employeemanagementsystem.entity.EmployeeEntity;
import com.evocoding.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.evocoding.employeemanagementsystem.mapper.EmployeeMapper;
import com.evocoding.employeemanagementsystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpolyeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDTO> findAll() {
        var employees = employeeRepository.findAll();
        return employeeMapper.maptoEmployeeDTOList(employees);
    }


    public EmployeeDTO findById(int id) {
        var employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("not found" + id));
        return employeeMapper.maptoEmpoleeDTO(employee);
    }


    public EmployeeDTO create(CreatedEmployeeDTO createdEmployeeDTO) {
        EmployeeEntity employee = employeeMapper.maptoEmployeeEntity(createdEmployeeDTO);
        return employeeMapper.maptoEmpoleeDTO(employeeRepository.save(employee));
    }


    public void update(int id, UpdateEmpolyeeDTO updateEmpolyeeDTO) {
        EmployeeEntity employee = getEmployeeEntity(id);
        employeeMapper.maptoEmployeeEntity(updateEmpolyeeDTO, employee);
        employeeRepository.save(employee);

    }


    public void delete(int id) {
        EmployeeEntity employee = getEmployeeEntity(id);
        employeeRepository.delete(employee);
    }

    private EmployeeEntity getEmployeeEntity(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("not found:" + id));
    }

    private static EmployeeEntity mapToEmployeeEntity(CreatedEmployeeDTO createdEmployeeDTO) {
        var employee = new EmployeeEntity();
        employee.setName(createdEmployeeDTO.getName());
        employee.setSurname(createdEmployeeDTO.getSurname());
        employee.setAge(createdEmployeeDTO.getAge());
        employee.setSalary(createdEmployeeDTO.getSalary());
        employee.setPosition(createdEmployeeDTO.getPosition());
        employee.setCompanyName(createdEmployeeDTO.getCompanyName());

        return employee;
    }


}

