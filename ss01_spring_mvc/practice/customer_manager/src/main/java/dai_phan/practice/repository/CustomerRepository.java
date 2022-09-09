package dai_phan.practice.repository;

import dai_phan.practice.model.Customer;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerRepository implements ICustomerRepository {
    public static List<Customer> customerList;

    static {
        customerList = Arrays.asList(
                new Customer("111", "Đạt", "datpham@gmail.com", "Quảng Ngãi"),
                new Customer("222", "Huỳnh Trung Thuyên", "thuyenhuynh@gmail.com", "Sao Hỏa"),
                new Customer("333", "Huỳnh Trung Dân", "thuyenhuynh@gmail.com", "Sao Hỏa"),
                new Customer("344", "Huỳnh Trung Nam", "thuyenhuynh@gmail.com", "Sao Hỏa"),
                new Customer("444", "Huỳnh Thị Thuyên", "thuyenhuynh@gmail.com", "Sao Hỏa"),
                new Customer("443", "Huỳnh Thị Thu Thủy", "thuyenhuynh@gmail.com", "Sao Hỏa")
        );

    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findId(String id) {
        if (id == null) {
            return null;
        } else {
            for (Customer c : customerList) {
                if (id.equals(c.getId())) {
                    return c;
                }
            }
        }
        return null;
    }
}
