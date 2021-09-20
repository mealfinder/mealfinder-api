package com.mealfinder.MealFinderApi.repositories;

import com.mealfinder.MealFinderApi.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
