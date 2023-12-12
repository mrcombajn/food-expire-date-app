package pl.expiredateapp.dtos.recipes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

import pl.expiredateapp.dtos.recipes.utils.Steps;
import pl.expiredateapp.entities.Recipe;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RecipeDto implements Serializable {

    private String name;

    private List<ProductDto> ingredients;

    private List<String> steps;

    private String description;

    public RecipeDto(Recipe recipe, List<ProductDto> ingredients) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.name = recipe.getName();
        this.ingredients = ingredients;

        try {
            this.steps = objectMapper.readValue(recipe.getSteps(), Steps.class).getSteps();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        this.description = recipe.getDescription();
    }

}
