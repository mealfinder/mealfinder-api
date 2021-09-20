package com.mealfinder.MealFinderApi.controllers;

import com.mealfinder.MealFinderApi.entities.Meal;
import com.mealfinder.MealFinderApi.dtos.request.OldMealDTO;
import com.mealfinder.MealFinderApi.services.MealService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/meals")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MealController {

    private MealService mealService;

    @GetMapping
    public List<Meal> getAll() throws Exception {
        return mealService.getAll();
    }

    @GetMapping("/old")
    public List<OldMealDTO> getlOldAll() throws Exception {
        return mealService.getOldAll();
    }
}
