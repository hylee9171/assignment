package com.assignment.assignment.service;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.repository.JobRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class DepartmentServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    EmployeesService employeesService;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    DepartmentService departmentService;


    @Test
    public void 부서별급여인상() throws Exception {
        departmentService.increaseSalaryByDept(20,10);

        Employee employee = employeesService.findOne(202);

        Assertions.assertThat(employee.getSalary()).isEqualTo(6600);

    }
}