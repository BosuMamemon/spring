package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/customLogin")
    public void getCustomLogin() {}

    @GetMapping("/admin")
    public void getAdmin() {}
}
