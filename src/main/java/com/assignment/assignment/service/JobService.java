package com.assignment.assignment.service;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.domain.Job;
import com.assignment.assignment.domain.JobHistory;
import com.assignment.assignment.repository.EmployeesRepository;
import com.assignment.assignment.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final EmployeesRepository employeesRepository;

    public Job findCurrentJob(int employeeId) {
        return jobRepository.findCurrentJob(employeeId);
    }

    public List<JobHistory> searchJobHistory(int employeeId) {
        return jobRepository.findJobHistory(employeeId);
    }
//
//    public void getJobHistory(String jobId) {
//        Job job = jobRepository.findJobInfo(jobId);
//        List<JobHistory> jobHistories = jobRepository.getJobHistory(jobId);
//        for(JobHistory j : jobHistories) {
//            job.addJobHistory(j);
//        }
//    }
}
