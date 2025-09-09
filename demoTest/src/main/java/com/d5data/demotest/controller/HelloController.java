package com.d5data.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String helloWord(){
        System.out.println("Hello World");
        return "Hello World";
    }
}