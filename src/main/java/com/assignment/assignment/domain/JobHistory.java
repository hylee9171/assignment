package com.assignment.assignment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name="job_history")
@IdClass(JobHistoryId.class)
@Getter
@NoArgsConstructor
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int employeeId;

    @Id
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @MapsId("employee_id")
    @ManyToOne(fetch = EAGER,optional = false)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

}
