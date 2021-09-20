package com.mealfinder.MealFinderApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meals")
public class MealController {

    @GetMapping
    public String getAll() {
        return "Hello world";
    }
}
