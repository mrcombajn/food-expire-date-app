package pl.expiredateapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.expiredateapp.controllers.requests.product.ProductRequest;
import pl.expiredateapp.dtos.products.ProductDto;
import pl.expiredateapp.services.ProductService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<Object> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value = "/product", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> getSingleProductById(@RequestParam ProductRequest productRequest) {
        return ResponseEntity.ok(productService.getProductById(productRequest));
    }

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable long id) {
        productService.deleteProductById(id);
    }

    @PostMapping
    void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }
}
