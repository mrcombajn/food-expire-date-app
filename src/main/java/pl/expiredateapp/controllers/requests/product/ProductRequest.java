package pl.expiredateapp.controllers.requests.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductRequest {

    private long id;

    private String barcode;

    @JsonCreator
    public ProductRequest(long id) {
        this.id = id;
    }

    @JsonCreator
    public ProductRequest(String barcode) {
        this.barcode = barcode;
    }
}
