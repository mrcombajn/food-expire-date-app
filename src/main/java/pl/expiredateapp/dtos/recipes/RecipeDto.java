package pl.expiredateapp.dtos.recipes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.expiredateapp.dtos.recipes.ProductDto;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RecipeDto implements Serializable {

    private String name;

    private List<ProductDto> ingredients;

    private List<String> steps;

    private String description;

}
