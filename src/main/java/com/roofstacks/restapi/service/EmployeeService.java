package com.roofstacks.restapi.service;

import com.roofstacks.restapi.api.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private Employee employee;
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {

    }

    public void setUser(Employee employee) {
        this.employee = employee;
        employeeList.add(employee);
    }

    public Optional<Employee> getUserById(int id) {
        Optional optional = Optional.empty();
        for (Employee employee : employeeList) {
            if(employee.getId() == id) {
                optional = Optional.of(employee);
                return optional;
            }

        }
        return optional;
    }
}