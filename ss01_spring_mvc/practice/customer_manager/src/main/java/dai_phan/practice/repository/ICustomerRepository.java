package dai_phan.practice.repository;

import dai_phan.practice.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findId(String id);
}
