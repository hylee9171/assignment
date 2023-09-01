package com.assignment.assignment.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "employees")
@Getter
@Setter
@DynamicUpdate
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

    @OneToMany(mappedBy = "employee", fetch = LAZY)
    private List<JobHistory> jobHistories = new ArrayList<>();

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;
}
