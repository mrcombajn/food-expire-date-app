package pl.expiredateapp.dtos;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public class RecipeDto implements Serializable {

    private final String name;

    private final List<ProductDto> ingredients;

    private final List<String> steps;

    private final String description;

}
