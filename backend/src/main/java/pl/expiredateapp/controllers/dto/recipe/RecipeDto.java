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

    /**
     * Recipe DTO name.
     */
    private String name;

    /**
     * Recipe DTO ingredients.
     */
    private List<RecipeProductDto> ingredients;

    /**
     * Recipe DTO steps.
     */
    private List<String> steps;

    /**
     * Recipe DTO description.
     */
    private String description;

    /**
     * Recipe DTO constructor.
     * @param recipe Recipe entity from database.
     */
    @SneakyThrows
    public RecipeDto(final Recipe recipe) {
        ObjectMapper objectMapper = new ObjectMapper();

        this.name = recipe.getName();
        this.ingredients = recipe
                .getProducts().stream().map(RecipeProductDto::new).toList();
        this.steps = objectMapper
                .readValue(recipe.getSteps(), Steps.class).getSteps();
        this.description = recipe.getDescription();
    }

}
