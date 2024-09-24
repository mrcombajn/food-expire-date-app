package pl.expiredateapp.controllers.requests.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductRequest {

    /**
     * Product request id.
     */
    private long id;

    /**
     * Product request barcode.
     */
    private String barcode;

    /**
     * Product request constructor.
     * @param id ID of product.
     */
    @JsonCreator
    public ProductRequest(final long id) {
        this.id = id;
    }

    /**
     * Product request constructor.
     * @param barcode Barcode of product.
     */
    @JsonCreator
    public ProductRequest(final String barcode) {
        this.barcode = barcode;
    }

}
