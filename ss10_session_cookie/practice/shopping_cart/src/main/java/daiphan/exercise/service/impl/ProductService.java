package daiphan.exercise.service.impl;

import daiphan.exercise.model.Product;
import daiphan.exercise.repository.IProductRepository;
import daiphan.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(Math.toIntExact(id));
    }
}
