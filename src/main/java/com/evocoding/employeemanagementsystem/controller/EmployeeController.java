package com.evocoding.employeemanagementsystem.controller;

import com.evocoding.employeemanagementsystem.dto.CreatedEmployeeDTO;
import com.evocoding.employeemanagementsystem.dto.EmployeeDTO;
import com.evocoding.employeemanagementsystem.dto.UpdateEmpolyeeDTO;
import com.evocoding.employeemanagementsystem.service.EmpolyeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final  EmpolyeeService empolyeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll(){
        return  ResponseEntity.status(HttpStatus.OK).body(empolyeeService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable int id){

        return  ResponseEntity.status(HttpStatus.OK).body(empolyeeService.findById(id));

    }


    @PostMapping
    public ResponseEntity<EmployeeDTO> creatEmployee(@RequestBody CreatedEmployeeDTO createdEmployeeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(empolyeeService.create(createdEmployeeDTO));

    }


    @PutMapping("/{id")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UpdateEmpolyeeDTO updateEmpolyeeDTO){
        empolyeeService.update(id,updateEmpolyeeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
    empolyeeService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
