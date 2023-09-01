package com.assignment.assignment.controller;

import com.assignment.assignment.domain.Department;
import com.assignment.assignment.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    @GetMapping("/department")
    public String searchDepartment(Model model, String departmentId) {
        List<Department> departments = new ArrayList<>();
        if(departmentId == null) {
            departments = departmentService.searchAllDepartment();
        } else {
            departments.add(departmentService.searchDepartment(Integer.parseInt(departmentId)));
        }

        model.addAttribute("departments", departments);
        return "details/departmentList";
    }

}
