package com.assignment.assignment.service.increase;

import com.assignment.assignment.domain.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateIncreasePolicy implements IncreasePolicy{
    @Override
    public int increase(Employee employee, int increasePercent) {
        return employee.getSalary()*increasePercent/100;
    }
}
