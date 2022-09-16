package daiphan.exercise.service.impl;


import daiphan.exercise.model.Product;
import daiphan.exercise.repository.IProductRepository;
import daiphan.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> productAll() {
        return productRepository.productAll();
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    @Override

    public Product insert(Product product) {
        return productRepository.save(product);
    }


    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public int delete(int id) {
        return productRepository.deleteLogic(id);
    }

    @Override
    public Product detail(int id) {
        return productRepository.findById(id).get();
    }
}
