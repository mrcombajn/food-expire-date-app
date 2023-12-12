package pl.expiredateapp.dtos.recipes;

import lombok.Getter;
import lombok.Setter;
import pl.expiredateapp.entities.Product;

import java.io.Serializable;

@Getter
@Setter
public class ProductDto implements Serializable {

    private int id;

    private String name;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
