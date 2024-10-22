package pl.expiredateapp.controllers.dto.recipe;

import lombok.Getter;
import lombok.Setter;
import pl.expiredateapp.repository.entity.product.Product;

@Getter
@Setter
public class RecipeProductDto {

    /**
     * Recipe Product DTO id.
     */
    private int id;

    /**
     * Recipe product DTO name.
     */
    private String name;

    /**
     * Recipe product DTO constructor.
     * @param product Product entity from database.
     */
    public RecipeProductDto(final Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
