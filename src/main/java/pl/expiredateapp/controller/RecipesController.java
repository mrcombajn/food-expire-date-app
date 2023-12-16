package pl.expiredateapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.expiredateapp.dtos.recipes.RecipeDto;
import pl.expiredateapp.services.ProductService;
import pl.expiredateapp.services.RecipeService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("recipes")
public class RecipesController {

    private final RecipeService recipeService;

    public List<RecipeDto> getAllAvailableRecipes() {
        return null;
    }
}
