package pl.expiredateapp.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.expiredateapp.dtos.recipes.RecipeDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="ingredients")
    private String ingredients;

    @Column(name="description")
    private String description;

    @Column(name="steps")
    private String steps;

    public Recipe (RecipeDto recipeDto) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.name = recipeDto.getName();
        try {
            this.ingredients = objectMapper.writeValueAsString(recipeDto.getIngredients());
            this.steps = objectMapper.writeValueAsString(recipeDto.getSteps());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        this.description = recipeDto.getDescription();
    }
}
