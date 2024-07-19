package com.roofstacks.restapi.api.model;

import com.roofstacks.restapi.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class User {
    private static int lastId;
    private int id;
    private String name;
    private int roleId;
    public User(String name, int roleId) {
        this.id = ++lastId;
        this.name = name;
        this.roleId = roleId;
    }

}