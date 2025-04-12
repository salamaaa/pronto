package com.softpedia.SecurityEx.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String hello(HttpServletRequest request){
        return "Hello Spring"+request.getSession().getId();
    }
}
