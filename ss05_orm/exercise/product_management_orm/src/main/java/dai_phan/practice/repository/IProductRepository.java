package dai_phan.practice.repository;

import dai_phan.practice.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> productAll();

    List<Product> searchByName(String name);

    Product insert(Product product);

    Product update(Product product);

    Product delete(Product product);

    Product detail(int id);
}
