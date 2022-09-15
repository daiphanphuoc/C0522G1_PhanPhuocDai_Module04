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
        return  productRepository.productAll();
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
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
    public Product delete(Product product) {
        return productRepository.delete(product);
    }

    @Override
    public Product detail(int id) {
        return productRepository.detail(id);
    }
}
