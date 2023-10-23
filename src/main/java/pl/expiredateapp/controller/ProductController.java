package pl.expiredateapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import pl.expiredateapp.entities.Product;
import pl.expiredateapp.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    Product getSingleProduct(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable long id) {
        productService.deleteProductById(id);
    }
}
