package dai_phan.practice.repository.impl;

import dai_phan.practice.model.Product;
import dai_phan.practice.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Bánh chưng", 5000, "dùng tốt", "Hương"));
        productMap.put(2, new Product(2, "Bánh Tét", 5000, "dùng tốt", "Hương"));
        productMap.put(3, new Product(3, "Bánh dày", 5000, "dùng tốt", "Hương"));
        productMap.put(4, new Product(4, "Bánh ít", 5000, "dùng tốt", "Hương"));
        productMap.put(5, new Product(5, "Bánh gói", 5000, "dùng tốt", "Hương"));
    }

    @Override
    public Map<Integer, Product> productAll() {
        return productMap;
    }

    @Override
    public Map<Integer, Product> searchByName(String name) {
        Map<Integer, Product> map = new HashMap<>();
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            if (entry.getValue().getName().contains(name)) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    @Override
    public Product insert(Product product) {
        return productMap.put(product.getId(), product);
    }

    @Override
    public Product update(Product product) {
        return productMap.put(product.getId(), product);
    }

    @Override
    public Product delete(int id) {
        return productMap.remove(id);
    }

    @Override
    public Product detail(int id) {
        return productMap.get(id);
    }
}
