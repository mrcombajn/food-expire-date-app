package pl.expiredateapp.dtos.products;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ProductDto implements Serializable {

    private String name;

    private String description;

    private String barCode;

    private Date expireDate;
}
