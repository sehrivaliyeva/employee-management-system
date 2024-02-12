package com.evocoding.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String age;
    private String position;
    private Double salary;
    private String companyName;





}
