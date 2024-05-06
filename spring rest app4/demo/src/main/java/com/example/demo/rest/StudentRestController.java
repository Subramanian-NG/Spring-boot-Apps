package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api")
public class StudentRestController {

    private List<Student> students = new ArrayList<Student>();

    @PostConstruct
    public void init() {
        students.add(new Student("user1", "last1", "user1@gmail.com"));
        students.add(new Student("user2", "last2", "user2@gmail.com"));
        students.add(new Student("user3", "last3", "user3@gmail.com"));
    }

    @GetMapping("students/list")
    public List<Student> getAllStudents() {
        return students;
    }

    // // to catch all the StudentNotFoundException in the project and throw custom
    // // error message
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException excep) {
    //     StudentErrorResponse errorResponse = new StudentErrorResponse(excep.getMessage(), HttpStatus.NOT_FOUND.value(),
    //             System.currentTimeMillis());
    //     return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    // }

    // // to catch all the exceptions and throw custom error message
    // @ExceptionHandler
    // public ResponseEntity<StudentErrorResponse> handleException(RuntimeException excep) {
    //     StudentErrorResponse errorResponse = new StudentErrorResponse(excep.getMessage(),
    //             HttpStatus.BAD_REQUEST.value(),
    //             System.currentTimeMillis());
    //     return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    // }

    @GetMapping("students/{index}")
    public Student getStudent(@PathVariable int index) {

        if (index < 0 || index >= students.size()) {
            throw new StudentNotFoundException("Invalid index for student " + index);
        }
        return students.get(index);
    }

}
