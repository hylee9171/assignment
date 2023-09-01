package com.assignment.assignment.service.increase;

import com.assignment.assignment.domain.Employee;

public interface IncreasePolicy {
    int increase(Employee employee, int increasePercent);
}
