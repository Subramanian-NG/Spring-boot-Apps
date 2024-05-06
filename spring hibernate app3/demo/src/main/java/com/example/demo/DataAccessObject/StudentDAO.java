package com.example.demo.DataAccessObject;

import java.util.List;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;

/**
 * StudentDAO
 */
public interface StudentDAO {

    public void save(Student student);

    public Student read(int id);

    public List<Student> findAll();

    public List<Student> findByEmail(String email);

    public void update(Student student);

    public void delete(int id);

    public void deleteAll();
}