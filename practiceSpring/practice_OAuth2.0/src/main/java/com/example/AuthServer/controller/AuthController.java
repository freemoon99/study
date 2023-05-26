package com.example.AuthServer.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @GetMapping("/")
    public String home(){
        return "Hello, Home!";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Hello, Secured!";
    }
}
