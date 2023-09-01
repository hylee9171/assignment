package com.assignment.assignment.repository;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.domain.Job;
import com.assignment.assignment.domain.JobHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobRepository {

    private final EntityManager em;

    private final EmployeesRepository employeesRepository;

    public Job findCurrentJob(int employeeId) {
        Employee employee = employeesRepository.findOne(employeeId);

        return em.find(Job.class, employee.getJobId());
    }

    public Job findJobInfo(String id) {

        return em.find(Job.class, id);
    }

    public List<JobHistory> findJobHistory(int employeeId) {
        return em.createQuery("select jh from JobHistory jh join jh.employee e where e.id = :id", JobHistory.class)
                                .setParameter("id",employeeId)
                                .getResultList();
    }
//
//    public List<JobHistory> getJobHistory(String id) {
//        return em.createQuery("select jh from JobHistory jh join jh.job j where j.id = :id", JobHistory.class)
//                .setParameter("id",id)
//                .getResultList();
//    }
}
