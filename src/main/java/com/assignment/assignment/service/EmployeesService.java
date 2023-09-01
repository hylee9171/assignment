package com.assignment.assignment.service;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.domain.JobHistory;
import com.assignment.assignment.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    private final JobService jobService;

    public Employee findOne(int id) {
        return employeesRepository.findOne(id);
    }

//    public Employee searchEmployeeHistory(int id) {
//        Employee employee = employeesRepository.findOne(id);
//        List<JobHistory> jobHistories = jobService.searchJobHistory(id);
//        for(JobHistory jobHistory : jobHistories) {
//            employee.addHistory(jobHistory);
//            jobService.getJobHistory(jobHistory.getJob().getId());
//        }
//        return employee;
//    }

    public List<Employee> findAllEmployees() {
        return employeesRepository.findEmployees();
    }

}
