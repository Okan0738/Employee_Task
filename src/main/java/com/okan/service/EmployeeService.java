package com.okan.service;

import com.okan.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {
    public static List<Employee> employees = new ArrayList<Employee>();

    public void saveEmployee(Employee employee) {
    employees.add(employee);
    }

    public List<Employee> readAllEmployees() {
        return employees;
    }
}
