package pl.expiredateapp.dtos.recipes;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductDto implements Serializable {

    private int id;

    private String name;

}
