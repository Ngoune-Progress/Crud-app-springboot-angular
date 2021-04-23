package com.example.peetfullstackapp.service;

import com.example.peetfullstackapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
     Employee addEmployee(Employee employee);
     void deleteEmployee(Long id);
     Employee findEmplById(Long id);
    Employee updateEmployee(Employee employee);
}
