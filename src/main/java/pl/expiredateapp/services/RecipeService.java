package pl.expiredateapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.expiredateapp.controllers.dto.recipe.RecipeDto;
import pl.expiredateapp.repository.entity.recipe.Recipe;
import pl.expiredateapp.repository.RecipeRepository;
import pl.expiredateapp.services.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipesRepository;

    /**
     * Gets all recipes from database.
     * @return All recipes from database.
     */
    public List<RecipeDto> getAllRecipes() {
        return ((List<Recipe>) recipesRepository.findAll())
                .stream()
                .map(RecipeDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Gets recipe by id.
     * @param id Recipe id.
     * @return Recipe with given id
     * or @EntityNotFoundException if recipe doesn't exist.
     */
    public Recipe getRecipeById(Long id) {
        return recipesRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find entity with given id!"));
    }

}
