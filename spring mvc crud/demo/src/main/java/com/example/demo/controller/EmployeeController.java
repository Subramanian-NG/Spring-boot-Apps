package com.example.demo.controller;

import java.util.List;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // since there is only constructor in EmployeeController, autowired not required
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.listAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/listemployees";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/addemployeeform";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/all";
    }

    @GetMapping("/showEditForm")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/addemployeeform";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/all";
    }

}
