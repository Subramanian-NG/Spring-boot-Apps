package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // EmployeeDAO employeeDAO;
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        // this.employeeDAO = employeeDAO;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> listAllEmployees() {
        // return employeeDAO.listAllEmployees();
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        // return employeeDAO.findById(id);
        Employee employee = null;
        Optional<Employee> returnObj = employeeRepository.findById(id);
        if (returnObj.isPresent())
            employee = returnObj.get();
        else {
            throw new RuntimeException("Employee not found--" + id);
        }
        return employee;
    }

    @Override
    // @Transactional
    public Employee save(Employee employee) {
        // return employeeDAO.save(employee);
        return employeeRepository.save(employee);
    }

    @Override
    // @Transactional
    public void deleteById(int id) {
        // employeeDAO.deleteById(id);
        employeeRepository.deleteById(id);
    }

}
