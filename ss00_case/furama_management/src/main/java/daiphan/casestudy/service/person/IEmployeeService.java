package daiphan.casestudy.service.person;

import daiphan.casestudy.dto.person.ICustomerDto;
import daiphan.casestudy.dto.person.IEmployeeDto;
import daiphan.casestudy.model.person.Employee;
import daiphan.casestudy.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService extends IFuramaService<Employee> {
    Page<IEmployeeDto> find(String searchName, String searchAddress, String searchPosition, Pageable pageable);

    List<IEmployeeDto> findAllDto();
}
