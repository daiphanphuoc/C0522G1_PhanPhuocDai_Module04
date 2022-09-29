package daiphan.casestudy.service.impl.person;

import daiphan.casestudy.model.person.CustomerType;
import daiphan.casestudy.repository.person.ICustomerTypeRepository;
import daiphan.casestudy.service.person.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.getById(id);
    }

    @Override
    public CustomerType insert(CustomerType element) {
        return customerTypeRepository.save(element);
    }

    @Override
    public CustomerType update(CustomerType element) {
        return customerTypeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return customerTypeRepository.deleteLogicById(id);
    }
}
