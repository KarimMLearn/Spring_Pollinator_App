package com.pollinator.demo.controller;

public class QuestionNotFoundException extends RuntimeException {
    QuestionNotFoundException(Long id) {
        super("Could not find Question " + id);
    }
}