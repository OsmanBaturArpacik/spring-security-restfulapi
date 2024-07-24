package com.roofstacks.restapi.service;

import com.roofstacks.restapi.api.model.User;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserListService {
    @Getter
    private List<User> userList = new ArrayList<>();
    private static final String FILE_NAME = "user_list.ser";

    public void saveUserList() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<User> loadUserList() {
        List<User> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            list = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserListService() {
        this.userList = loadUserList();
    }
    public void addUser(User user) {
        //check other users
        userList.add(user);
    }
}