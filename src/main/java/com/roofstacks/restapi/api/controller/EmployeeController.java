package com.roofstacks.restapi.api.controller;

import com.roofstacks.restapi.api.model.Employee;
import com.roofstacks.restapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("employee")
    @ResponseBody
    public ResponseEntity<String> setNameToListAndWelcomeMessage(@RequestParam("name") String name, @RequestParam("roleId") int roleId) {
        if(name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name parameter cannot be empty.");
        }
        Employee employee = new Employee(name, roleId);
        employeeService.setUser(employee);
        return ResponseEntity.status(HttpStatus.OK).body("User (id: " + employee.getId() +")  successfully added to list.");
    }


    //request query param
    @GetMapping("employee")
    @ResponseBody
    public ResponseEntity<String> getUserByIdQueryParam(@RequestParam("id") int id) {
        Optional user = employeeService.getUserById(id);
        if (user.isPresent()) {
            Employee employeeResponse = (Employee) user.get();
            return ResponseEntity.status(HttpStatus.OK).body("User exist.\n" + employeeResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User (id: " + id +") is not exist.");
    }


    //uri path param
    @GetMapping("employee/{id}")
    @ResponseBody
    public ResponseEntity<String> getUserByIdPathParam(@PathVariable("id") int id) {
        Optional user = employeeService.getUserById(id);
        if (user.isPresent()) {
            Employee employeeResponse = (Employee) user.get();
            return ResponseEntity.status(HttpStatus.OK).body("User exist.\n" + employeeResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User (id: " + id +") is not exist.");
    }
}
