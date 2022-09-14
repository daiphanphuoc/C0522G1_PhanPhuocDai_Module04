package dai_phan.practice.repository;

import dai_phan.practice.model.Product;

import java.util.Map;

public interface IProductRepository {
    Map<Integer, Product> productAll();

    Map<Integer, Product> searchByName(String name);

    Product insert(Product product);

    Product update(Product product);

    Product delete(int id);

    Product detail(int id);
}
