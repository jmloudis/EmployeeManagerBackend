package com.loudis.employeemanagementproject.service;

import com.loudis.employeemanagementproject.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService
{
    List<Employee> getAllEmployees();
    ResponseEntity<Employee> getEmployeeById(Long id);
    Employee createEmployee(Employee employee);
    ResponseEntity<Employee> updateEmployeeById(Employee employeeInput, Long id);
    ResponseEntity<Map<String, Boolean>> deleteEmployeeById(Long id);

}
