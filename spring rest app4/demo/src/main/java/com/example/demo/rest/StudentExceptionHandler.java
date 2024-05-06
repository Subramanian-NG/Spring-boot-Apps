package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//this is the global exception handler, which catch all the exceptions in the project. When you create exceptionHandler functions in restcontroller,those are specific to that restcontroller. To make the exceptionHandler functions global to all the rest controller, we have create controlleradvice

@ControllerAdvice
public class StudentExceptionHandler {

    // to catch all the StudentNotFoundException in the project and throw custom
    // error message
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException excep) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(excep.getMessage(), HttpStatus.NOT_FOUND.value(),
                System.currentTimeMillis());
        return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // to catch all the exceptions and throw custom error message
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(RuntimeException excep) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(excep.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                System.currentTimeMillis());
        return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
}
