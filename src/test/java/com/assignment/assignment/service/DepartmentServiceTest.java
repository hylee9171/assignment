package com.assignment.assignment.service;

import com.assignment.assignment.domain.Department;
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
import java.util.List;

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
    public void 부서위치() throws Exception {
        List<Department> departmentList = departmentService.searchAllDepartment();
        System.out.println("DepartmentServiceTest.부서위치=="+departmentList.get(0).getId());
        Assertions.assertThat(departmentList.get(0)).isInstanceOf(Department.class);

    }

    @Test
    public void 부서() throws Exception {
        Department departmentList = departmentService.searchDepartment(20);
        System.out.println("DepartmentServiceTest.부서위치=="+departmentList.getId());
        Assertions.assertThat(departmentList).isInstanceOf(Department.class);

    }


}