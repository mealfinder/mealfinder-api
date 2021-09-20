package com.mealfinder.MealFinderApi.dtos.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OldMealListDTO {
    private OldMealDTO meals[];
}
