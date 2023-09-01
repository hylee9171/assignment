package com.assignment.assignment.repository;

import com.assignment.assignment.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {

    private final EntityManager em;

    public List<Department> searchAllDepartment() {
        return em.createQuery("select d from Department d order by id", Department.class)
                .getResultList();
    }
    public Department searchDepartment(int id) {
        return em.find(Department.class, id);
    }

}
