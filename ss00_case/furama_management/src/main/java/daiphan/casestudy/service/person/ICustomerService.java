package daiphan.casestudy.service.person;

import daiphan.casestudy.dto.person.ICustomerDto;
import daiphan.casestudy.model.person.Customer;
import daiphan.casestudy.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService extends IFuramaService<Customer> {
    Page<ICustomerDto> find(String searchName, String searchAddress, String searchType, Pageable pageable);
    List<ICustomerDto> findAllDto();

    ICustomerDto findByIdCitizen(String idCitizen);
}
