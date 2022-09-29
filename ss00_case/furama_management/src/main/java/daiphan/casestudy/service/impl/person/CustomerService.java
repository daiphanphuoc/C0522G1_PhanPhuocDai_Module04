package daiphan.casestudy.service.impl.person;

import daiphan.casestudy.model.person.Customer;
import daiphan.casestudy.repository.person.ICustomerRepository;
import daiphan.casestudy.service.person.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public Customer insert(Customer element) {
        return customerRepository.save(element);
    }

    @Override
    public Customer update(Customer element) {
        return customerRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.deleteLogicById(id);
    }
}
