package pl.expiredateapp.controllers.dto.recipe;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

import lombok.SneakyThrows;
import pl.expiredateapp.controllers.dto.recipe.utils.Steps;
import pl.expiredateapp.repository.entity.recipe.Recipe;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RecipeDto implements Serializable {

    private String name;

    private List<RecipeProductDto> ingredients;

    private List<String> steps;

    private String description;

    @SneakyThrows
    public RecipeDto(Recipe recipe) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.name = recipe.getName();
        this.ingredients = recipe.getProducts().stream().map(RecipeProductDto::new).toList();
        this.steps = objectMapper.readValue(recipe.getSteps(), Steps.class).getSteps();
        this.description = recipe.getDescription();
    }

}
