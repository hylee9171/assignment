package com.assignment.assignment.controller;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.domain.JobHistory;
import com.assignment.assignment.service.EmployeesService;
import com.assignment.assignment.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/jobHistory/new")
    public String createForm(Model model) {
        List<JobHistory> jobHistories = new ArrayList<>();
        model.addAttribute("jobHistories", jobHistories);
        return "employees/jobHistory";
    }

    @GetMapping("/jobHistory")
    public String employeeHistory(Model model, String employeeId) {
        List<JobHistory> jobHistories = new ArrayList<>();
        if(employeeId != null) {
            jobHistories = jobService.searchJobHistory(Integer.parseInt(employeeId));
        }

        model.addAttribute("jobHistories",jobHistories);
        return "employees/jobHistory";
    }

}
