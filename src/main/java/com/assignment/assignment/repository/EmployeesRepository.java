package com.assignment.assignment.repository;

import com.assignment.assignment.domain.Employee;
import com.assignment.assignment.domain.JobHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeesRepository {

    private final EntityManager em;

    public List<Employee> findEmployees() {
        return em.createQuery("select e from Employee e", Employee.class)
                .getResultList();
    }
    public Employee findOne(int id) {
        return em.find(Employee.class, id);
    }

    public void save(Employee employee) {
        em.persist(employee);
    }




}
