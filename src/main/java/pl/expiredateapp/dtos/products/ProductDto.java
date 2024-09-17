package pl.expiredateapp.dtos.products;


import lombok.Getter;
import lombok.Setter;

import pl.expiredateapp.entities.Product;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ProductDto implements Serializable {

    private int id;

    private String name;

    private String description;

    private String barCode;

    private Date expireDate;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.barCode = product.getBarCode();
        this.expireDate = product.getExpireDate();
    }
}
