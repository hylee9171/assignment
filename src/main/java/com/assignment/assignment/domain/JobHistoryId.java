package com.assignment.assignment.domain;

import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JobHistoryId implements Serializable {

    private int employeeId;
    private Date startDate;

}
