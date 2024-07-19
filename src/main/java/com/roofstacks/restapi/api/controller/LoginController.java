package com.roofstacks.restapi.api.controller;

import com.roofstacks.restapi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
    private LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {this.loginService = loginService;}

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login() {
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }
    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity<String> logout() {
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

}
