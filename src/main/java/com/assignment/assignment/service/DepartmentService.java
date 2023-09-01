package com.assignment.assignment.service;

import com.assignment.assignment.domain.Department;
import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.repository.DepartmentRepository;
import com.assignment.assignment.repository.EmployeesRepository;
import com.assignment.assignment.service.increase.IncreasePolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeesRepository employeesRepository;

    private final IncreasePolicy increasePolicy;

    public Department searchDepartment(int id) {
        return departmentRepository.searchDepartment(id);
    }

    public Department searchAddress(int id) {
        return departmentRepository.searchDepartment(id);
    }

    public void increaseSalaryByDept(int id, int percent) {
        Department department = searchDepartment(id);
        List<Employee> employeeList = department.getEmployees();
        for (Employee employee : employeeList) {
            int increaseAmount = increasePolicy.increase(employee, percent);
            employee.setSalary(employee.getSalary()+increaseAmount);
            employeesRepository.save(employee);
        }
    }

}
