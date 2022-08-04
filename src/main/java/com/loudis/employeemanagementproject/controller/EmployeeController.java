package com.loudis.employeemanagementproject.controller;

import com.loudis.employeemanagementproject.model.Employee;
import com.loudis.employeemanagementproject.service.EmployeeServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController
{
    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> listAllEmployees()
    {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> listEmployeeById(@PathVariable Long id)
    {
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return this.employeeService.createEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeInput, @PathVariable Long id)
    {
        return this.employeeService.updateEmployeeById(employeeInput, id);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id)
    {
        return this.employeeService.deleteEmployeeById(id);
    }
}
