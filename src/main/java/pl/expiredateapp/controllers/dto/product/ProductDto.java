/**
 * pl.expiredateapp.dto.product is a package for product dto definitions.
 */
package pl.expiredateapp.controllers.dto.product;

import lombok.Getter;
import lombok.Setter;

import pl.expiredateapp.repository.entity.product.Product;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * ProductDto class.
 */
@Getter
@Setter
public final class ProductDto implements Serializable {

    private int id;

    private String name;

    private String description;

    private String barCode;

    private LocalDate expireDate;

    /**
     * ProductDto constructor.
     * @param product Product entity from database.
     */
    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.barCode = product.getBarCode();
        this.expireDate = product.getExpireDate();
    }
}
