package dai_phan.practice.repository.impl;

import dai_phan.practice.model.Customer;
import dai_phan.practice.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository implements ICustomerRepository {

    private static Map<Integer, Customer> customerMap = new HashMap<>();


    static {
        customerMap.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerMap.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerMap.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerMap.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerMap.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerMap.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public Map<Integer, Customer> findAll() {
        return customerMap;
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
