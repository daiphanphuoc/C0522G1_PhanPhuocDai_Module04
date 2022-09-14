package dai_phan.practice.repository;

import dai_phan.practice.model.Customer;

import java.util.Map;

public interface ICustomerRepository {

    Map<Integer, Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
