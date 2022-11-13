package com.crudexample.crudOperations.service;

import com.crudexample.crudOperations.model.Employee;
import com.crudexample.crudOperations.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
