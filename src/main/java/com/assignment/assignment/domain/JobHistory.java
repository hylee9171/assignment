package com.assignment.assignment.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "job_history")
@Getter
@Setter
public class JobHistory {

    @Id
    @GeneratedValue
    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;


}
