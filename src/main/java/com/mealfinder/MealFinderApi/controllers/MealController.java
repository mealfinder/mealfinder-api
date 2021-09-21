package com.mealfinder.MealFinderApi.controllers;

import com.mealfinder.MealFinderApi.dtos.request.OldMealDTO;
import com.mealfinder.MealFinderApi.entities.Meal;
import com.mealfinder.MealFinderApi.services.MealService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/meals")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MealController {

    private MealService mealService;

    @GetMapping
    public ResponseEntity<List<Meal>> getByName(@RequestParam(required = false, name="s") final String search) throws Exception {
        if(search == null){
            return ResponseEntity.ok().body(mealService.getAll());
        } else {
            return ResponseEntity.ok().body(mealService.getByName(search));
        }
    }

    @GetMapping("/old")
    public List<OldMealDTO> getOldAll() throws Exception {
        return mealService.getOldAll("");
    }
}
