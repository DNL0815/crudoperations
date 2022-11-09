package com.crudexample.crudOperations.controller;

import com.crudexample.crudOperations.model.Employee;
import com.crudexample.crudOperations.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeResources {
    private final EmployeeService employeeService;

    public EmployeeResources(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
//        Optional employee = employeeService.findEmployeeById(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id")Long id){
        employeeService.deleteEmployee(id);;
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
