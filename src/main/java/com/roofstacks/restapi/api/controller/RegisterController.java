package com.roofstacks.restapi.api.controller;

import com.roofstacks.restapi.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterController {
    private RegisterService registerService;
    @Autowired
    public RegisterController(RegisterService registerService) {this.registerService = registerService;}

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

}
