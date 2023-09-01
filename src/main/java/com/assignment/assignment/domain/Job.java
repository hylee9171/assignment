package com.assignment.assignment.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Job {

    @Id
    @GeneratedValue
    @Column(name="job_id")
    private String id;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;

    @OneToMany(mappedBy = "job", fetch = LAZY)
    private List<JobHistory> jobHistories = new ArrayList<>();

    public void addJobHistory(JobHistory jobHistory) {
        jobHistories.add(jobHistory);
        jobHistory.setJob(this);
    }

}
