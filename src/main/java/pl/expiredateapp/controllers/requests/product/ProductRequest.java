/**
 * pl.expiredateapp.controllers.requests.product is a package for controller's product definitions.
 */
package pl.expiredateapp.controllers.requests.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Product request class.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ProductRequest {

    private long id;

    private String barcode;

    /**
     * Product request constructor.
     * @param id ID of product.
     */
    @JsonCreator
    public ProductRequest(long id) {
        this.id = id;
    }

    /**
     * Product request constructor.
     * @param barcode Barcode of product.
     */
    @JsonCreator
    public ProductRequest(String barcode) {
        this.barcode = barcode;
    }
}