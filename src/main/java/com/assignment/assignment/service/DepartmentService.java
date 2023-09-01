package com.assignment.assignment.service;

import com.assignment.assignment.domain.Department;
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

    public List<Department> searchAllDepartment() {
        return departmentRepository.searchAllDepartment();
    }
    public Department searchDepartment(int id) {
        return departmentRepository.searchDepartment(id);
    }


}
