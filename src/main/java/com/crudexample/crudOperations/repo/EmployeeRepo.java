package com.crudexample.crudOperations.repo;

import com.crudexample.crudOperations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface EmployeeRepo extends JpaRepository<Employee,Long> {



}
