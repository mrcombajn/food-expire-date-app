package pl.expiredateapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.expiredateapp.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
