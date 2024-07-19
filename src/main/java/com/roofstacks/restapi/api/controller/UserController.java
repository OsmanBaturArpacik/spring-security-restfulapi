package com.roofstacks.restapi.api.controller;

import com.roofstacks.restapi.api.model.User;
import com.roofstacks.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("user")
    @ResponseBody
    public ResponseEntity<String> setNameToListAndWelcomeMessage(@RequestParam("name") String name, @RequestParam("roleId") int roleId) {
        if(name.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name parameter cannot be empty.");
        }
        User user = new User(name, roleId);
        userService.setUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User (id: " + user.getId() +")  successfully added to list.");
    }


    //request query param
    @GetMapping("user")
    @ResponseBody
    public ResponseEntity<String> getUserByIdQueryParam(@RequestParam("id") int id) {
        Optional user = userService.getUserById(id);
        if (user.isPresent()) {
            User userResponse = (User) user.get();
            return ResponseEntity.status(HttpStatus.OK).body("User exist.\n" + userResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User (id: " + id +") is not exist.");
    }


    //uri path param
    @GetMapping("user/{id}")
    @ResponseBody
    public ResponseEntity<String> getUserByIdPathParam(@PathVariable("id") int id) {
        Optional user = userService.getUserById(id);
        if (user.isPresent()) {
            User userResponse = (User) user.get();
            return ResponseEntity.status(HttpStatus.OK).body("User exist.\n" + userResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User (id: " + id +") is not exist.");
    }
}
