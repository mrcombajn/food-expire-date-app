package pl.expiredateapp.repository.entity.product;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.hibernate.annotations.GenericGenerator;
import pl.expiredateapp.controllers.dto.product.ProductDto;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    /**
     * Product entity ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Product entity name.
     */
    @Column(name = "product_name")
    private String name;

    /**
     * Product entity description.
     */
    @Column(name = "product_description")
    private String description;

    /**
     * Product entity barcode.
     */
    @Column(name = "bar_code")
    private String barCode;

    /**
     * Product entity expire date.
     */
    @Column(name = "expire_date")
    private LocalDate expireDate;

    /**
     * Product entity constructor.
     * @param productDto Product DTO.
     */
    public Product(final ProductDto productDto) {
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.barCode = productDto.getBarCode();
        this.expireDate = productDto.getExpireDate();
    }

}
