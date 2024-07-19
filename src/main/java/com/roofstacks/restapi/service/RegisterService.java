package com.roofstacks.restapi.service;

import com.roofstacks.restapi.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {
    private UserListService userListService;
    @Autowired
    public RegisterService(UserListService userListService) {this.userListService = userListService;}

    public RegisterService() {

    }

    public void setUser(String username, String password) {
        //check for other users
        userListService.addUser(new User(username, password));
    }
}
