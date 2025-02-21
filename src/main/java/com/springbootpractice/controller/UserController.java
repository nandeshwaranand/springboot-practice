package com.springbootpractice.controller;

import com.springbootpractice.dto.request.UserAccountRequest;
import com.springbootpractice.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserAccountService userAccountService;

    public UserController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userAccountService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userAccountService.getUserAccountByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Object> createUserAccount(@RequestBody UserAccountRequest userAccountRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userAccountService.createUserAccount(userAccountRequest));
    }
}
