package com.example.registerapp.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerapp.model.Employee;
import com.example.registerapp.service.EmployeeRegisterService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class EmployeeRegisterController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRegisterController.class);

    @Autowired
    private EmployeeRegisterService employeeRegisterService;

    @PostMapping("/registerEmployee")
    @Operation(summary = "Create a register for a new employee")
    public ResponseEntity<Void> registerEmployee(@RequestBody Employee employee) {
        employeeRegisterService.register(employee);
        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(employee.toString()).build().toUri())
            .build();
    }

    @GetMapping("/employess/")
    @Operation(summary = "Gets all the employess")
    public List<Employee> updateEmployees() {
        return  employeeRegisterService.getAllEmployess();
    }

    @PutMapping("/updateEmployee/")
    @Operation(summary = "Updates an employes")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeRegisterService.updateEmployee(employee);
    }
}
