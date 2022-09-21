package daiphan.casestudy.model.person;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;


    public Customer() {
    }

    public Customer(String name, String iDCitizen, Date birthday, boolean sex, String phone,
                    String email, String address, CustomerType customerType) {
        super(name, iDCitizen, birthday, sex, phone, email, address);
        this.customerType = customerType;
    }

    @Override
    public String getInfo() {
        Date date = getBirthday();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString  = df.format(date);
        return String.format("%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s@@%s", getName(), getIdCitizen(),dateString,
                isSex(), getPhone(), getEmail(), getAddress(), id, customerType.getName());
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

}
