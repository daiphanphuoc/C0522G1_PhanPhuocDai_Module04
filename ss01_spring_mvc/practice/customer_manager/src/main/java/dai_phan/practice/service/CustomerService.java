package dai_phan.practice.service;

import dai_phan.practice.model.Customer;
import dai_phan.practice.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository repository;
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findId(String id) {
        return repository.findId(id);
    }
}
