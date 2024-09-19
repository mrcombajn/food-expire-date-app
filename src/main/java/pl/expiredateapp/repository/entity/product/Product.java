package pl.expiredateapp.repository.entity.product;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import pl.expiredateapp.controllers.dto.product.ProductDto;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="bar_code")
    private String barCode;

    @Column(name="expire_date")
    private LocalDate expireDate;

    public Product(ProductDto productDto) {
        this.name = productDto.getName();
        this.description = productDto.getDescription();
        this.barCode = productDto.getBarCode();
        this.expireDate = productDto.getExpireDate();
    }
}
