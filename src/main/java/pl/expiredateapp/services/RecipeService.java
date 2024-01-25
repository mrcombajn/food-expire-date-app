package pl.expiredateapp.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.expiredateapp.dtos.recipes.RecipeDto;
import pl.expiredateapp.entities.Recipe;
import pl.expiredateapp.entities.exceptions.EntityNotFoundException;

import pl.expiredateapp.repositories.RecipesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipesRepository recipesRepository;

    private final ProductService productService;

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
