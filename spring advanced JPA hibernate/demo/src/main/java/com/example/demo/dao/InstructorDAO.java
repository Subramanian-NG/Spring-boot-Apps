package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

public interface InstructorDAO {
    public void save(Instructor instructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructor(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructionDetail(int id);

    public List<Course> findCoursesByInstructor(int id);

    public Instructor findInstructorAndCoursesUsingJoin(int id);

    public void updateInstructor(Instructor updatedInstructor);

    public void saveCourse(Course course);

    public void deleteCourse(int id);

    public void createCourse(Course course);

    public Course findStudentsInCourse(int id);

    public Student findCoursesEnrolledByStudent(int id);

    public void addCoursesToStudent(Student student);

    public void deleteStudent(int id);

    public Student findStudentById(int id);

}
