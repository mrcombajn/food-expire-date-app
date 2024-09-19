/**
 * pl.expiredateapp.repository is a package for repository classes.
 */
package pl.expiredateapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.expiredateapp.repository.entity.product.Product;

/**
 * ProductRepository repository class.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
