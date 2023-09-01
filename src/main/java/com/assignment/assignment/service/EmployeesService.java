package com.assignment.assignment.service;

import com.assignment.assignment.domain.Department;
import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.repository.EmployeesRepository;
import com.assignment.assignment.service.increase.IncreasePolicy;
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

    private final DepartmentService departmentService;

    private final IncreasePolicy increasePolicy;

    public Employee findOne(int id) {
        return employeesRepository.findOne(id);
    }

    public List<Employee> findAllEmployees() {
        return employeesRepository.findEmployees();
    }

    public List<Employee> searchEmpByDept(int deptId) {
        Department departments = departmentService.searchDepartment(deptId);
        return departments.getEmployees();
    }

    public List<Employee> IncreaseSalaryByDept(List<Employee> employees, int rate) {
        for(Employee employee : employees) {
            employeesRepository.saveSalary(employee, increasePolicy.increase(employee, rate));
        }

        return employees;
    }

}
