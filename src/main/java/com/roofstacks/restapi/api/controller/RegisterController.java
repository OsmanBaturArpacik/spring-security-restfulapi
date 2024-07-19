package com.roofstacks.restapi.api.controller;

import com.roofstacks.restapi.service.RegisterService;
import com.roofstacks.restapi.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RegisterController {
    private RegisterService registerService;
    private UserListService userListService;
    @Autowired
    public RegisterController(RegisterService registerService, UserListService userListService) {this.registerService = registerService;this.userListService = userListService;}

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> register(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            registerService.setUser(username, password);
            userListService.saveUserList();
        }
        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Account created.");
    }

    @GetMapping("/register-lists")
    @ResponseBody
    public ResponseEntity<String> register() {
        return ResponseEntity.status(HttpStatus.OK).body(userListService.getUserList().toString());
    }
}
