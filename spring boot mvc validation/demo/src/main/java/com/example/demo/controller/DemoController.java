package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {

    @GetMapping("hello")
    public String sayHello(Model model) {
        model.addAttribute("date", new Date(System.currentTimeMillis()));
        return "helloworld";
    }

    @GetMapping("getForm")
    public String getForm() {
        return "inputform";
    }

    @GetMapping("showOutput")
    public String showOutput() {
        return "outputpage";
    }

    @RequestMapping("processForm")
    public String processForm(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        String processedData = studentName.toUpperCase();
        model.addAttribute("upperCaseData", processedData);
        return "processform";
    }

    @RequestMapping("processForm1")
    public String processForm(@RequestParam("studentName") String studentName, Model model) {
        String processedData = studentName.toUpperCase();
        model.addAttribute("upperCaseData", processedData);
        return "processform";
    }

}
