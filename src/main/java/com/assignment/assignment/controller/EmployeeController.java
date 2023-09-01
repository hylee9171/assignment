package com.assignment.assignment.controller;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeesService employeesService;

    @GetMapping("/employee/new")
    public String createForm(Model model) {
        List<Employee> employees = employeesService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "details/employeeList";
    }

    @GetMapping("/employee")
    public String employeeInfo(Model model, String id) {
        Employee employee = new Employee();
        if(id != null) {
            employee = employeesService.findOne(Integer.parseInt(id));
        }
        model.addAttribute("employees",employee);
        return "details/employeeList";
    }

    @GetMapping("/employee/salary/new")
    public String createSalaryForm(Model model) {

        List<Employee> employees = employeesService.findAllEmployees();

        model.addAttribute("employees", employees);

        return "details/deptSalary";
    }
    @GetMapping("/employee/salary")
    public String IncreaseSalaryByDept(Model model, String departmentId, String percent) {

        List<Employee> employees = new ArrayList<>();
        if(departmentId == null) {
            employees = employeesService.findAllEmployees();
        } else {
            employees = employeesService.searchEmpByDept(Integer.parseInt(departmentId));
            employeesService.IncreaseSalaryByDept(employees,Integer.parseInt(percent));
        }
        model.addAttribute("employees", employees);


        return "details/deptSalary";
    }


}
