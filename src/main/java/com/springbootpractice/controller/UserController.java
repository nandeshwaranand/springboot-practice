package com.springbootpractice.controller;

import com.springbootpractice.components.UserAccountResponseAssembler;
import com.springbootpractice.dto.request.UserAccountRequest;
import com.springbootpractice.dto.response.UserAccountResponse;
import com.springbootpractice.entity.UserAccount;
import com.springbootpractice.service.UserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserAccountService userAccountService;

    private final UserAccountResponseAssembler responseAssembler;

    public UserController(UserAccountService userAccountService, UserAccountResponseAssembler responseAssembler) {
        this.userAccountService = userAccountService;
        this.responseAssembler = responseAssembler;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userAccountService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserAccountResponse> getUserById(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseAssembler.toModel(userAccountService.getUserAccountByUserId(userId)));
    }

    @PostMapping
    public ResponseEntity<UserAccountResponse> createUserAccount(@RequestBody UserAccountRequest userAccountRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userAccountService.createUserAccount(userAccountRequest));
    }
}
