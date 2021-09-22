package com.mealfinder.MealFinderApi.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OldMealListDTO {
    private OldMealDTO meals[];
}
