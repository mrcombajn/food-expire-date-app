package pl.expiredateapp.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expiredateapp.entities.Recipe;
import pl.expiredateapp.entities.exceptions.EntityNotFoundException;
import pl.expiredateapp.repositories.ProductRepository;
import pl.expiredateapp.repositories.RecipesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipesRepository recipesRepository;

    private final ProductRepository productRepository;

    public List<Recipe> getAllRecipes(Long productId) {
        return (List<Recipe>) recipesRepository
                .findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find entity with given id!"));
    }

}
