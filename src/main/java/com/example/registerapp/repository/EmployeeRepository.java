package com.example.registerapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.registerapp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT " +
        "    new com.example.registerapp.model.Employee(employee.id,employee.firstSurname,employee.secondSurname,employee.name,employee.otherNames,employee.country," +
        " employee.idType,employee.idNumber,employee.email,employee.firstDay,employee.jobCategory,employee.status) " +
        "FROM " +
        "    Employee employee " +
        "ORDER BY " +
        "    employee.email")
    Employee findEmployeeByEmail(String email);

    @Query("SELECT " +
        "    new com.example.registerapp.model.Employee(employee.id,employee.firstSurname,employee.secondSurname,employee.name,employee.otherNames,employee.country," +
        " employee.idType,employee.idNumber,employee.email,employee.firstDay,employee.jobCategory,employee.status) " +
        "FROM " +
        "    Employee employee " +
        "ORDER BY " +
        "    employee.name")
    List<Employee> getAllBy();

}