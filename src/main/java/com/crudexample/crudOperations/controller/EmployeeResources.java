package com.crudexample.crudOperations.controller;

import com.crudexample.crudOperations.exceptions.EmployeeNotFoundException;
import com.crudexample.crudOperations.model.Employee;
import com.crudexample.crudOperations.repo.EmployeeRepo;
import com.crudexample.crudOperations.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeResources {

    final static Logger logger = Logger.getLogger(String.valueOf(EmployeeResources.class));

    EmployeeRepo employeeRepo;

    EmployeeService employeeService;


    public EmployeeResources(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/employees")
    List<Employee> all() {
        return employeeRepo.findAll();
    }

    @PostMapping("/employees")
    Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    @PutMapping("/employees/update")
    Employee updateEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }


    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepo.deleteById(id);
    }


    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeRepo.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setPhone(newEmployee.getPhone());
                    employee.setImageUrl(newEmployee.getImageUrl());
                    employee.setJobTitle(newEmployee.getJobTitle());
                    return employeeRepo.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepo.save(newEmployee);
                });
    }
}






