package pl.expiredateapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.expiredateapp.controllers.requests.product.ProductRequest;
import pl.expiredateapp.dtos.products.ProductDto;

import pl.expiredateapp.entities.Product;
import pl.expiredateapp.entities.exceptions.EntityNotFoundException;

import pl.expiredateapp.repositories.ProductRepository;
import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        return productRepository.save(product);
    }

    public List<ProductDto> getAllProducts() {
        return ((List<Product>) productRepository.findAll()).stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public ProductDto getProductById(ProductRequest productRequest) {
        return new ProductDto(productRepository
                .findById(productRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Cannot find entity with given id!")));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
