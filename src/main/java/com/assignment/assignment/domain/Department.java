package com.assignment.assignment.domain;

import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "departments")
@Getter
public class Department {

    @Id
    @GeneratedValue
    @Column(name="department_id")
    private int id;
    private String departmentName;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "department", fetch = LAZY)
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "department", fetch = LAZY)
    private List<JobHistory> jobHistories = new ArrayList<>();
}
