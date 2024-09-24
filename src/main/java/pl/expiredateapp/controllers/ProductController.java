package pl.expiredateapp.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pl.expiredateapp.controllers.requests.product.ProductRequest;
import pl.expiredateapp.controllers.dto.product.ProductDto;
import pl.expiredateapp.services.ProductService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public final class ProductController {

    private final ProductService productService;

    /**
     * Get all products from database.
     * @return List of products from database.
     */
    @GetMapping(
            value = "/products",
            produces = "application/json")
    public ResponseEntity<Object> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * Product from database.
     * @param productRequest Request for a product.
     * @return Try to get product from database,
     * otherwise it will return 400 status.
     */
    @GetMapping(
            value = "/product",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Object> getSingleProductById(
            @RequestParam final ProductRequest productRequest) {
        return ResponseEntity.ok(productService.getProductById(productRequest));
    }

    /**
     * Deletes a product from database.
     * @param productRequest ProductRequest to delete.
     */
    @DeleteMapping(
            value = "/product",
            consumes = "application/json",
            produces = "application/json")
    void deleteProductById(@RequestParam final ProductRequest productRequest) {
        productService.deleteProductById(productRequest);
    }

    /**
     * Adding product to database.
     * @param productDto Product to add.
     */
    @PostMapping(
            value = "/product",
            consumes = "application/json")
    void addProduct(@RequestBody final ProductDto productDto) {
        productService.addProduct(productDto);
    }
}
