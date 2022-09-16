package daiphan.exercise.service;


import daiphan.exercise.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> productAll();

    List<Product> searchByName(String name);

    Product insert(Product product);

    Product update(Product product);

    int delete(int id);

    Product detail(int id);
}
