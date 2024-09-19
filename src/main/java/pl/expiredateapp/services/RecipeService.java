package pl.expiredateapp.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.expiredateapp.controllers.dto.recipe.RecipeDto;
import pl.expiredateapp.repository.entity.recipe.Recipe;
import pl.expiredateapp.services.exceptions.EntityNotFoundException;

import pl.expiredateapp.repository.RecipeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipesRepository;

    public List<RecipeDto> getAllRecipes(Long id) {
        return ((List<Recipe>) recipesRepository.findAll())
                .stream()
                .map(RecipeDto::new)
                .collect(Collectors.toList());
    }

    public Recipe getRecipeById(Long id) {
        return recipesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find entity with given id!"));
    }

}
