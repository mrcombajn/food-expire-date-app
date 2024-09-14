package pl.expiredateapp.controllers.requests.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProductRequest {

    private int id;

    private String barcode;

    @JsonCreator
    public ProductRequest(int id) {
        this.id = id;
    }

    @JsonCreator
    public ProductRequest(String barcode) {
        this.barcode = barcode;
    }
}
