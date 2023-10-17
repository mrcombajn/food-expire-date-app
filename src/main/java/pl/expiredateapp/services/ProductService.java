package pl.expiredateapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.expiredateapp.repositories.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
}
