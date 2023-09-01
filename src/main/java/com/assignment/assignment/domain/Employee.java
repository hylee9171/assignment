package com.assignment.assignment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="employee_id")
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private int salary;
    private Long managerId;
    private String jobId;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<JobHistory> jobHistories = new ArrayList<>();

    public void addHistory(JobHistory jobHistory) {
        jobHistories.add(jobHistory);
        jobHistory.setEmployee(this);
    }

    @JsonBackReference
    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;
}
