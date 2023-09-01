package com.assignment.assignment.controller;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeesService employeesService;

    @GetMapping("/employee/new")
    public String createForm(Model model) {
        List<Employee> employees = employeesService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/employeeList";
    }

    @GetMapping("/employee")
    public String employeeInfo(Model model, String id) {
        Employee employee = new Employee();
        if(id != null) {
            employee = employeesService.findOne(Integer.parseInt(id));
        }
        model.addAttribute("employees",employee);
        return "employees/employeeList";
    }




}
