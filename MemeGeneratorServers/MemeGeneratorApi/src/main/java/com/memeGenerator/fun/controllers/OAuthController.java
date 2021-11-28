package com.memeGenerator.fun.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    @GetMapping("/")
    public String helloWorld() {
        return "hello World";
    }

    @GetMapping("/restricted")
    public String helloWorldRestricted() {
        return "hello World restricted";
    }
}