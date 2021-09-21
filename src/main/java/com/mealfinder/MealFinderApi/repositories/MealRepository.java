package com.mealfinder.MealFinderApi.repositories;

import com.mealfinder.MealFinderApi.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query(value = "SELECT * FROM meals m WHERE m.name LIKE %?1%", nativeQuery = true)
    List<Meal> findByName(final String search);

}
