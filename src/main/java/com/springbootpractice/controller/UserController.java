package com.springbootpractice.controller;

import com.springbootpractice.dto.request.UserAccountRequest;
import com.springbootpractice.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserAccountService userAccountService;

    public UserController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/{userId}")
    public Object getUserById(@PathVariable Long userId){
        return userAccountService.getUserAccountByUserId(userId);
    }

    @PostMapping
    public Object createUserAccount(@RequestBody UserAccountRequest userAccountRequest){
        return userAccountService.createUserAccount(userAccountRequest);
    }
}
