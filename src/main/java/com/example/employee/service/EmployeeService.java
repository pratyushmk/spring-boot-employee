package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    // CREATE
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    // READ
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    //UPDATE
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());
        return employeeRepository.save(emp);
    }

    // DELETE
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}
