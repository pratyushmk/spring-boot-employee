package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value="/update/{empId}", method=RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable(value = "empId") Long id, @RequestBody Employee emp) {
        return employeeService.updateEmployee(id, emp);
    }

    @RequestMapping(value="/delete/{empId}", method=RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable(value = "empId") Long id) {
        employeeService.deleteEmployee(id);
    }
}
