package com.assignment.assignment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue
    @Column(name="department_id")
    private int id;
    private String departmentName;

    @JsonBackReference
    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @JsonBackReference
    @OneToMany(mappedBy = "department", fetch = LAZY)
    private List<Employee> employees = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "department", fetch = LAZY)
    private List<JobHistory> jobHistories = new ArrayList<>();
}
