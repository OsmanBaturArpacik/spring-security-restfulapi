package com.roofstacks.restapi.service;

import com.roofstacks.restapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private User user;
    private List<User> userList = new ArrayList<>();

    public UserService() {

    }
    public void setUser(User user) {
        this.user = user;
        userList.add(user);
    }
    public Optional<User> getUserById(int id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if(user.getId() == id) {
                optional = Optional.of(user);
                return optional;
            }

        }
        return optional;
    }
}
