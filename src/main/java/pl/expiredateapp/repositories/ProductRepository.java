package pl.expiredateapp.repositories;

import org.springframework.stereotype.Repository;
import pl.expiredateapp.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {


    public List<Product> getProducts() {
        List<Product> p = new ArrayList<>();

        p.add(new Product(1, "cos"));
        p.add(new Product(2, "drugiecos"));
        return p;
    }
}
