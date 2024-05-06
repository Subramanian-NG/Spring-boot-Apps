package com.example.demo.DataAccessObject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    // autowrired not needed if there is only one constructor
    // inject entity manager. with injection, we dont need to use new to assign
    // entity manager
    @Autowired
    public StudentDAOImpl(EntityManager entityManagerObj) {
        entityManager = entityManagerObj;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student read(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("from Student WHERE email=:emailparam", Student.class);
        query.setParameter("emailparam", email);
        return query.getResultList();
    }

    @Override
    @Transactional

    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = read(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Student");
        int rowsUpdated = query.executeUpdate();
    }

}
