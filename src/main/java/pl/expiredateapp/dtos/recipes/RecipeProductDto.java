package pl.expiredateapp.dtos.recipes;

import lombok.Getter;
import lombok.Setter;
import pl.expiredateapp.entities.Product;

@Getter
@Setter
public class RecipeProductDto {

    private int id;

    private String name;

    public RecipeProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
