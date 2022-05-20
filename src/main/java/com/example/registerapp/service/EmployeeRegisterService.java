package com.example.registerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registerapp.model.Country;
import com.example.registerapp.model.Employee;
import com.example.registerapp.repository.EmployeeRepository;

@Service
public class EmployeeRegisterService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void register(Employee employee) {
        employee.setEmail(createEmail(employee));
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployess(){
        return employeeRepository.getAllBy();
    }

    public String createEmail(Employee employee) {

        StringBuilder newEmailwithId = new StringBuilder();
        StringBuilder tempEmail = new StringBuilder();
        CounterSingleton instance = CounterSingleton.getInstance();

        tempEmail.append(employee.getName()).append(".").append(employee.getSecondSurname()).append("@");

        if (employee.getCountry() == Country.COLOMBIA) {
            tempEmail.append("cidenet.com.co");
        } else {
            tempEmail.append("cidenet.com.us");
        }

        String buildEmail = tempEmail.toString();
        Employee email = employeeRepository.findEmployeeByEmail(buildEmail);

        if (email != null) {

            String[] split = buildEmail.split("@");
            String toString = split[0];

            newEmailwithId.append(toString);
            newEmailwithId.append(instance.counter).append("@");
            newEmailwithId.append(split[1]);
            instance.increment();
            return newEmailwithId.toString();
        }
        return tempEmail.toString();
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
