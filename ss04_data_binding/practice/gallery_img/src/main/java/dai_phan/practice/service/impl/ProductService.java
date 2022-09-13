package dai_phan.practice.service.impl;

import dai_phan.practice.model.Product;
import dai_phan.practice.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private List<Product> products = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);

    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (Product element : products) {
            if (element.getId() == id) {
                element = product;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }
}
