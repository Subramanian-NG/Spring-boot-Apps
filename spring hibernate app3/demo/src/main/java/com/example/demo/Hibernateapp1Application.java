package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.DataAccessObject.StudentDAO;
import com.example.demo.DataAccessObject.StudentDAOImpl;
import com.example.demo.entity.Student;

@SpringBootApplication
public class Hibernateapp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Hibernateapp1Application.class, args);
	}

	// injecting StudentDAO object to commandLineRunner function. we are creating a
	// new StudentDAO object here through injection. new StudentDAO object will be
	// created at runtime when spring scan all the spring objects. This is one
	// spring object
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// CommandLineRunner cmdLineRunnerObj = (arg1) -> {
		// System.out.println("Hello from cmdline run");
		// };

		// return custom -> {
		// System.out.println("Hello world");
		// }

		// return cmdLineRunnerObj;
		return runner -> {
			createSingleStudent(studentDAO);
			// readSingleStudent(studentDAO);
			// readStudentwithCrit(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};

	}

	private void createSingleStudent(StudentDAO studentDAO) {
		Student student = new Student("user2", "last2", "user2@gmail.com");
		studentDAO.save(student);
	}

	private void readSingleStudent(StudentDAO studentDAO) {
		Student student = studentDAO.read(2);
		System.out.println(student);
	}

	private void readStudentwithCrit(StudentDAO studentDAO) {
		System.out.println(studentDAO.findAll());
		System.out.println(studentDAO.findByEmail("user2@gmail.com"));
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student student = studentDAO.read(2);
		student.setLastName("newlast");
		studentDAO.update(student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

}
