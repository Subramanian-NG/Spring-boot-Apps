package com.example.demo.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class InstuctorDAOImpl implements InstructorDAO {

    private EntityManager entityManager;

    // constructor injection. autowired annotation not needed when there is only
    // constructor in InstructorImpl
    public InstuctorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        System.out.println("printing data-----");
        Instructor instructor = entityManager.find(Instructor.class, id);
        System.out.println("printing course data-----" + instructor.getCourses());
        return instructor;
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor = findInstructorById(id);
        List<Course> courses = instructor.getCourses();
        System.out.println("Check courses before deleting--" + courses);
        for (Course course : courses) {
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructionDetail(int id) {
        InstructorDetail instructorDetail = findInstructorDetailById(id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructor(int id) {
        System.out.println("--------findCoursesByInstructor----------");
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data",
                Course.class);
        query.setParameter("data", id);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorAndCoursesUsingJoin(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i JOIN FETCH i.courses where i.id = :data",
                Instructor.class);
        query.setParameter("data", id);
        Instructor instructor = query.getSingleResult();
        return instructor;

    }

    @Override
    @Transactional
    public void updateInstructor(Instructor updatedInstructor) {
        entityManager.merge(updatedInstructor);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    public Course findCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        return course;
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course = findCourseById(id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void createCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findStudentsInCourse(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select i from Course i JOIN FETCH i.students where i.id = :data",
                Course.class);
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findCoursesEnrolledByStudent(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select i from Student i JOIN FETCH i.courses where i.id = :data",
                Student.class);
        query.setParameter("data", id);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void addCoursesToStudent(Student student) {
        entityManager.merge(student);
    }

    public Student findStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = findStudentById(id);
        entityManager.remove(student);
    }

}
