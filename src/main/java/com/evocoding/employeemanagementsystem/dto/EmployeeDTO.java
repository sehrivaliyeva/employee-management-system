package com.evocoding.employeemanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private int id;
    private String name;
    private String surname;
    private String age;
    private String position;
    private Double salary;
    private String companyName;

}
