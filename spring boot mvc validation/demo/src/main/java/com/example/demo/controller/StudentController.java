package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> countiesList;

    @Value("${programmingLanguages}")
    List<String> planguageList;

    @Value("${operatingSystems}")
    List<String> osList;

    @GetMapping("/getStudentForm")
    public String getStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("studentObj", student);
        model.addAttribute("countries", countiesList);
        model.addAttribute("programmingLanguages", planguageList);
        model.addAttribute("osList", osList);
        return "studentform";
    }

    @PostMapping("/processStudentForm")
    public String processStudent(@ModelAttribute("studentObj") Student student) {
        System.out.println("Student Info--" + student);
        return "studentconfirmation";
    }

}
