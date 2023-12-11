package pl.expiredateapp.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.expiredateapp.dtos.products.ProductDto;

import pl.expiredateapp.entities.Product;
import pl.expiredateapp.entities.exceptions.EntityNotFoundException;

import pl.expiredateapp.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find entity with given id!"));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
