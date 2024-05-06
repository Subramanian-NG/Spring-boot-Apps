package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    @PostMapping("/processCustomerForm")
    public String showCustomerData(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        System.out.println(customer);
        if (bindingResult.hasErrors())
            return "customerform";
        else
            return "showcustomerdata";
    }

}
