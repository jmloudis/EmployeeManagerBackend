package com.loudis.employeemanagementproject.service;

import com.loudis.employeemanagementproject.exception.ResourceNotFoundException;
import com.loudis.employeemanagementproject.model.Employee;
import com.loudis.employeemanagementproject.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long id) {
        //return this.employeeRepository.findById(id).get();
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
        return ResponseEntity.ok(employee);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<Employee> updateEmployeeById(Employee employeeInput, Long id) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));

        employee.setFirstName(employeeInput.getFirstName());
        employee.setLastName(employeeInput.getLastName());
        employee.setEmail(employeeInput.getEmail());

        Employee updatedEmployee = this.employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(Long id) {
        //this.employeeRepository.deleteById(id);
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
        this.employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
