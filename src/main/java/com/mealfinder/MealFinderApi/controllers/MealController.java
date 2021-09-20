package com.mealfinder.MealFinderApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@RestController
@RequestMapping("/meals")
public class MealController {

    @GetMapping
    public String getAll() throws IOException {
        var url = new URL("https://www.themealdb.com/api/json/v2/1/search.php?s=");
        var connection = url.openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        InputStream response = connection.getInputStream();
        String responseBody;
        try (Scanner scanner = new Scanner(response)) {
            responseBody = scanner.useDelimiter("\\A").next();
        }
        return responseBody;
    }
}
