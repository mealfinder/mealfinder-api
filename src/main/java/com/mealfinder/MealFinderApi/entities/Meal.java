package com.mealfinder.MealFinderApi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.type.TextType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meals")
@TypeDefs({
        @TypeDef(name = "text", typeClass = TextType.class)
})
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String category;

    @Column
    private String area;

    @Type(type = "text")
    @Column(nullable = false)
    private String instructions;

    @Column
    private String thumb;

    @Column
    private String youtube;

    @Column
    private String source;

    public Meal(String strMeal, String strCategory, String strArea, String strInstructions, String strMealThumb, String strYoutube, String strSource) {
        this.name = strMeal;
        this.category = strCategory;
        this.area = strArea;
        this.instructions = strInstructions;
        this.thumb = strMealThumb;
        this.youtube = strYoutube;
        this.source = strSource;
    }
}
