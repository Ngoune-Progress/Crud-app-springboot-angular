package com.example.peetfullstackapp.Repo;

import com.example.peetfullstackapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
