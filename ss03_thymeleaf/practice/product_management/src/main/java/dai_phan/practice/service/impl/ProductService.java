package dai_phan.practice.service.impl;

import dai_phan.practice.model.Product;
import dai_phan.practice.repository.IProductRepository;
import dai_phan.practice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> productAll() {
        return new ArrayList<>(productRepository.productAll().values());
    }

    @Override
    public List<Product> searchByName(String name) {
        return new ArrayList<>(productRepository.searchByName(name).values());
    }

    @Override
    public Product insert(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Product delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public Product detail(int id) {
        return productRepository.detail(id);
    }
}
