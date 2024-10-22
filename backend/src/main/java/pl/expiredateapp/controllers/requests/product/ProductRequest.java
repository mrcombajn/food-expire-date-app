package pl.expiredateapp.controllers.requests.product;

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

}
