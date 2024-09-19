package pl.expiredateapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.expiredateapp.controllers.requests.product.ProductRequest;
import pl.expiredateapp.controllers.dto.product.ProductDto;
import pl.expiredateapp.repository.entity.product.Product;
import pl.expiredateapp.services.exceptions.EntityNotFoundException;
import pl.expiredateapp.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public final class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        return productRepository.save(product);
    }

    public List<ProductDto> getAllProducts() {
        return ((List<Product>) productRepository.findAll()).stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public ProductDto getProductById(ProductRequest productRequest) {
        return new ProductDto(productRepository.findById(productRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Cannot find product with given id!")));
    }

    public void deleteProductById(ProductRequest productRequest) {
        productRepository.deleteById(productRequest.getId());
    }
}
