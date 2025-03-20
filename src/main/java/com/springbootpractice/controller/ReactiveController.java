package com.springbootpractice.controller;

import com.springbootpractice.service.reactive.ReactorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reactive")
@RestController
public class ReactiveController {

    private final ReactorService reactorService;

    public ReactiveController(ReactorService reactorService) {
        this.reactorService = reactorService;
    }

    @PostMapping("/test")
    public ResponseEntity<Object> reactiveTest(){
        reactorService.reactorTest();
        return ResponseEntity.status(HttpStatus.CREATED).body("Reactive is successful.");
    }
}
