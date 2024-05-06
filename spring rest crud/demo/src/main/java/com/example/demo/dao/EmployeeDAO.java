package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> listAllEmployees();
    
    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
