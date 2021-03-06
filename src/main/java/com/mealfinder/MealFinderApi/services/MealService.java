package com.mealfinder.MealFinderApi.services;

import com.google.gson.Gson;
import com.mealfinder.MealFinderApi.dtos.request.OldMealListDTO;
import com.mealfinder.MealFinderApi.entities.Meal;
import com.mealfinder.MealFinderApi.dtos.request.OldMealDTO;
import com.mealfinder.MealFinderApi.repositories.MealRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MealService {

    private MealRepository mealRepository;

    public List<Meal> getAll() throws Exception {
        List<Meal> meals = mealRepository.findAll();
        if(meals.isEmpty()) {
            meals = insertOldMeals("");
        }
        return meals;
    }

    public List<Meal> getByName(String search) throws Exception {
        List<Meal> meals = mealRepository.findByName(search);
        if(meals.isEmpty()) {
            meals = insertOldMeals(search);
        }
        return meals;
    }

    public List<OldMealDTO> getOldAll(String search) throws Exception {
        var url = new URL("https://www.themealdb.com/api/json/v1/1/search.php?s="+search);
        var connection = url.openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        InputStream response = connection.getInputStream();
        String responseBody;
        try (Scanner scanner = new Scanner(response)) {
            responseBody = scanner.useDelimiter("\\A").next();
        }

        Gson gson = new Gson();
        OldMealListDTO oldMeals = gson.fromJson(responseBody, OldMealListDTO.class);

        List<OldMealDTO> meals = new ArrayList<>();

        try {
            meals = List.of(oldMeals.getMeals());
        } catch (Exception e) {
            System.out.println("No results");
        }

        return meals;
    }

    public List<Meal> createMeals(List<Meal> meals) {
        return mealRepository.saveAll(meals);
    }

    public List<Meal> insertOldMeals(String search) throws Exception {
        var oldMeals = getOldAll(search);
        List<Meal> newMeals = new ArrayList<>();
        oldMeals.forEach((oldMeal) -> {
            Meal newMeal = new Meal(
                oldMeal.getIdMeal(),
                oldMeal.getStrMeal(),
                oldMeal.getStrCategory(),
                oldMeal.getStrArea(),
                oldMeal.getStrInstructions(),
                oldMeal.getStrMealThumb(),
                oldMeal.getStrYoutube(),
                oldMeal.getStrSource()
            );
            newMeals.add(newMeal);
        });
        return createMeals(newMeals);
    }

}