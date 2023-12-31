package pl.expiredateapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import pl.expiredateapp.dtos.products.ProductDto;
import pl.expiredateapp.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getSingleProduct(@PathVariable long id) {
        return productService.getProductById(id);
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
