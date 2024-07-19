package com.roofstacks.restapi.api.model;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Getter
    private String username;
    private String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
