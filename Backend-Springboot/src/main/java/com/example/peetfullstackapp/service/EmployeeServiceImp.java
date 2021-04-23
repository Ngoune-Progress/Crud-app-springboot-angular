package com.example.peetfullstackapp.service;

import com.example.peetfullstackapp.Repo.EmployeeRepo;
import com.example.peetfullstackapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EmployeeServiceImp implements  EmployeeService{
@Autowired
 private EmployeeRepo employeeRepo;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }



    @Override
    public Employee findEmplById(Long id) {
        Optional<Employee> optional = employeeRepo.findById(id);
        Employee employee = new Employee();
        employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }
        else {
            throw  new RuntimeException("Impossible to Find Employee with such Id ");
        }
        return  employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


    @Override
    public void deleteEmployee(Long id) {
         Employee employee = findEmplById(id);
         employeeRepo.delete(employee);

    }


}
