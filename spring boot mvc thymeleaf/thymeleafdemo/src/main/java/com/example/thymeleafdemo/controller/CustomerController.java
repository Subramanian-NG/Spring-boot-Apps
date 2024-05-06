package com.example.thymeleafdemo.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleafdemo.model.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

    // to intercept request(like a middleware) before doing validation and trim all
    // string objects
    @InitBinder
    public void initBinder(WebDataBinder databinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        databinder.registerCustomEditor(String.class, trimmerEditor);
    }

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
