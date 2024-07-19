package com.roofstacks.restapi.api.model;

import lombok.Data;

@Data
public class Employee {
    private static int lastId;
    private int id;
    private String name;
    private int roleId;
    public Employee(String name, int roleId) {
        this.id = ++lastId;
        this.name = name;
        this.roleId = roleId;
    }

}