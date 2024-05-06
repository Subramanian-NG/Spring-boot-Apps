package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/manager")
    public String showManagerPage() {
        return "manager";
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }

}
