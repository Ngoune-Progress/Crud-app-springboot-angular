package com.example.peetfullstackapp.controller;

import com.example.peetfullstackapp.model.Employee;
import com.example.peetfullstackapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
@Autowired
private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return  new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id){

        return  new ResponseEntity<>(employeeService.findEmplById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    public  ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
        return  new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return  new ResponseEntity<>(employeeService.updateEmployee(employee),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Employee>  deleteEmployee(@PathVariable("id") Long id){
     employeeService.deleteEmployee(id);
     return  new ResponseEntity<>(HttpStatus.OK);
    }



}
