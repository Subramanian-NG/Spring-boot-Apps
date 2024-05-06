package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.InstructorDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// instructorDAO injection(creation of new instance) is done automatically since
	// this is a bean
	@Bean
	public CommandLineRunner cmdLineRunner(InstructorDAO instructorDAO) {
		return runnerObj -> {
			// createInstructor(instructorDAO);
			// findInstructorById(6, instructorDAO);
			// deleteInstructor(6, instructorDAO);
			// findInstructorDetailById(1, instructorDAO);
			// deleteInstructorDetail(5, instructorDAO);
			// createInstructorWithCourses(instructorDAO);
			// findCoursesByInstructor(2, instructorDAO);
			// findInstructorAndCoursesUsingJoin(2, instructorDAO);
			// updatedInstructorInfo(2, instructorDAO);
			// createCourseAndReviews(instructorDAO);
			// deleteCourse(10, instructorDAO);
			// createCoursesAndStudents(instructorDAO);
			// findStudentsInCourse(10, instructorDAO);
			// findCoursesEnrolledByStudent(1, instructorDAO);
			// addCoursesToStudent(1, instructorDAO);
			deleteStudent(1, instructorDAO);
		};
	}

	private void deleteStudent(int id, InstructorDAO instructorDAO) {
		instructorDAO.deleteStudent(id);
	}

	private void addCoursesToStudent(int id, InstructorDAO instructorDAO) {
		Student student = instructorDAO.findCoursesEnrolledByStudent(id);
		List<Course> courses = student.getCourses();
		courses.add(new Course("Android 1"));
		courses.add(new Course("IOS 1"));
		courses.add(new Course("Operating Systems"));
		instructorDAO.addCoursesToStudent(student);
	}

	private void findCoursesEnrolledByStudent(int id, InstructorDAO instructorDAO) {
		Student student = instructorDAO.findCoursesEnrolledByStudent(id);
		System.out.println("student info--" + student);
		System.out.println("Course info--" + student.getCourses());
	}

	private void findStudentsInCourse(int id, InstructorDAO instructorDAO) {
		Course course = instructorDAO.findStudentsInCourse(id);
		System.out.println("Course info--" + course);
		System.out.println("Student info--" + course.getStudents());
	}

	private void createCoursesAndStudents(InstructorDAO instructorDAO) {

		Course course = new Course("New course 2");
		Student student1 = new Student("first1", "last1", "test1@gmail.com");
		Student student2 = new Student("first2", "last2", "test2@gmail.com");
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		course.setStudents(students);
		instructorDAO.createCourse(course);

	}

	private void deleteCourse(int id, InstructorDAO instructorDAO) {
		instructorDAO.deleteCourse(id);
	}

	private void createCourseAndReviews(InstructorDAO instructorDAO) {
		Course course = new Course("New course1");
		Review review1 = new Review("Good course");
		Review review2 = new Review("Bad course");
		List<Review> reviews = new ArrayList<Review>();
		reviews.add(review1);
		reviews.add(review2);
		course.setReviews(reviews);
		instructorDAO.saveCourse(course);
	}

	private void updatedInstructorInfo(int id, InstructorDAO instructorDAO) {
		Instructor instructor = instructorDAO.findInstructorById(id);
		instructor.setEmail("new1@test.com");

		List<Course> courses = new ArrayList<Course>();
		Course course = new Course("IOS");
		course.setInstructor(instructor);
		courses.add(course);

		course = new Course("Android");
		course.setInstructor(instructor);
		courses.add(course);

		instructor.setCourses(courses);

		instructorDAO.updateInstructor(instructor);
	}

	private void findInstructorAndCoursesUsingJoin(int id, InstructorDAO instructorDAO) {
		Instructor instructor = instructorDAO.findInstructorAndCoursesUsingJoin(id);
		System.out.println("Join fetch");
		System.out.println("Instructor basic info--" + instructor);
		System.out.println("Courses info--" + instructor.getCourses());
	}

	private void findCoursesByInstructor(int instructorId, InstructorDAO instructorDAO) {
		System.out.println("Instructor basic info--" + instructorDAO.findInstructorById(instructorId));
		List<Course> courses = instructorDAO.findCoursesByInstructor(instructorId);
		System.out.println("Courses info--" + courses);
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("user1", "last1", "user1@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("www.test2.com", "Soccer");

		instructor.setInstructorDetail(instructorDetail);

		List<Course> courses = new ArrayList<Course>();
		Course course = new Course("Web Framework4");
		course.setInstructor(instructor);
		courses.add(course);

		course = new Course("Big data4");
		course.setInstructor(instructor);
		courses.add(course);

		instructor.setCourses(courses);
		instructorDAO.save(instructor);
	}

	private void deleteInstructorDetail(int id, InstructorDAO instructorDAO) {
		instructorDAO.deleteInstructionDetail(id);
	}

	private void findInstructorDetailById(int id, InstructorDAO instructorDAO) {
		InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(id);
		System.out.println("Instructor details -- " + instructorDetail);
		System.out.println("Instructor info -- " + instructorDetail.getInstructor());
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("subbu1", "last1", "test1@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("www.test1.com", "Soccer");

		instructor.setInstructorDetail(instructorDetail);

		instructorDAO.save(instructor);
	}

	private void findInstructorById(int id, InstructorDAO instructorDAO) {
		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println("instructor basic info--" + instructor);
		System.out.println("instructor details--" + instructor.getInstructorDetail());
		System.out.println("instructor courses--" + instructor.getCourses());
	}

	private void deleteInstructor(int id, InstructorDAO instructorDAO) {
		instructorDAO.deleteInstructor(id);
	}

}
