package pl.expiredateapp.controllers.dto.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;

import pl.expiredateapp.repository.entity.product.Product;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public final class ProductDto implements Serializable {

    /**
     * Product DTO ID.
     */
    private int id;

    /**
     * Product DTO name.
     */
    private String name;

    /**
     * Product DTO description.
     */
    private String description;

    /**
     * Product DTO barcode.
     */
    private String barCode;

    /**
     * Product DTO expire date.
     */
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate expireDate;

    /**
     * ProductDto constructor.
     * @param product Product entity from database.
     */
    public ProductDto(final Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.barCode = product.getBarCode();
        this.expireDate = product.getExpireDate();
    }

    /**
     * ProductDto default constructor.
     */
    @JsonCreator
    public  ProductDto() {
    }

}
