package com.example.cloudstorage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public file!";
    }

    @GetMapping("/private")
    public String privateEndpoint() {
        return "This is my private file";
    }
}
