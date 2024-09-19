package pl.expiredateapp.controllers.dto.recipe;

import lombok.Getter;
import lombok.Setter;
import pl.expiredateapp.repository.entity.product.Product;

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
