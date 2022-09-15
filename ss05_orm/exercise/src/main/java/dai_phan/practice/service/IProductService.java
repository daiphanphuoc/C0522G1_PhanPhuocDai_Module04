package dai_phan.practice.service;

import dai_phan.practice.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> productAll();

    List<Product> searchByName(String name);

    Product insert(Product product);

    Product update(Product product);

    Product delete(Product product);

    Product detail(int id);
}
