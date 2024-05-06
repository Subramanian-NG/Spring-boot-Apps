package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> listAllEmployees() {
        TypedQuery typedQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = typedQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee udpatedEmployee = entityManager.merge(employee);
        return udpatedEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employeeToDelete = findById(id);
         entityManager.remove(employeeToDelete);
    }

}
