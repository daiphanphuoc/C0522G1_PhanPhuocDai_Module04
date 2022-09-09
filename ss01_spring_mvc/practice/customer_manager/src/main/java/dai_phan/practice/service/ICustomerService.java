package dai_phan.practice.service;

import dai_phan.practice.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findId(String id);
}
