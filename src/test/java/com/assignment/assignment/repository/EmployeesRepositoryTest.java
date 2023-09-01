package com.assignment.assignment.repository;

import com.assignment.assignment.domain.*;
import com.assignment.assignment.service.DepartmentService;
import com.assignment.assignment.service.EmployeesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class EmployeesRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    EmployeesService employeesService;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    DepartmentService departmentService;

    @Test
    public void 직원이력() throws Exception {
        Employee employee = employeesService.findOne(101);
        System.out.println("employee = " + employee.getJobHistories());
        Assertions.assertThat(employee).isInstanceOf(Employee.class);


//        List<JobHistory> jobHistory = jobRepository.findJobHistory(101);
//        for (JobHistory jobHistory2 : jobHistory) {
//            System.out.println("==========JobHistory================ " + jobHistory2.getJob().getId());
//        }
    }

    @Test
    public void 부서() throws Exception {
        Department department = departmentService.searchDepartment(20);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(department);
        System.out.println("jsonStr = " + jsonStr);
        Assertions.assertThat(department).isInstanceOf(Department.class);


//        List<JobHistory> jobHistory = jobRepository.findJobHistory(101);
//        for (JobHistory jobHistory2 : jobHistory) {
//            System.out.println("==========JobHistory================ " + jobHistory2.getJob().getId());
//        }
    }

    @Test
    @Rollback(value = false)
    public void 급여() throws Exception {
        Department department = departmentService.searchDepartment(90);
        List<Employee> employees = department.getEmployees();
        for(Employee employee : employees) {
            System.out.println("EmployeesRepositoryTest.이전급여==========" + employee.getSalary());
        }
        employeesService.IncreaseSalaryByDept(employees, 10);
        for(Employee employee : employees) {
            System.out.println("EmployeesRepositoryTest.이후급여==========" + employee.getSalary());
        }
    }

}