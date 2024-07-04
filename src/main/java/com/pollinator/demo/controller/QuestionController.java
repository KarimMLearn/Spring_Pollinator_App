package com.pollinator.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @GetMapping("/")
    public String index() {
        return "D7ashoooo";
    }

}