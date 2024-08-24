package com.github.isaquesb.happy_java_api.app.http.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String index() {
        return "Welcome!";
    }
}
