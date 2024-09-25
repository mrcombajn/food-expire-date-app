package pl.expiredateapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pl.expiredateapp.controllers.dto.product.ProductDto;
import pl.expiredateapp.controllers.requests.product.ProductRequest;
import pl.expiredateapp.repository.entity.product.Product;
import pl.expiredateapp.repository.ProductRepository;
import pl.expiredateapp.services.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public final class ProductService {

    private final ProductRepository productRepository;

    /**
     * Method that adds product to database.
     * @param productDto Product to add.
     * @return Product if adding was successful.
     */
    public Product addProduct(final ProductDto productDto) {
        Product product = new Product(productDto);
        return productRepository.save(product);
    }

    /**
     * Method that gets all products from database.
     * @return Gets all product from database.
     */
    public List<ProductDto> getAllProducts() {
        return ((List<Product>) productRepository
                .findAll()).stream().map(ProductDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Method that gets ProductDto from database.
     * @param productRequest Product request.
     * @return @ProductDto from database or
     * EntityNotFoundException if product doesn't exist.
     */
    public ProductDto getProductById(final ProductRequest productRequest) {
        return new ProductDto(productRepository.findById(productRequest.getId())
                .orElseThrow(
                        () -> new EntityNotFoundException("Cannot find product with given id!")));
    }

    public void deleteProductById(final ProductRequest productRequest) {
        productRepository.deleteById(productRequest.getId());
    }

}
