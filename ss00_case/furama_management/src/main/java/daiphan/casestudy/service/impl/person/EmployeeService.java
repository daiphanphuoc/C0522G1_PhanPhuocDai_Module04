package daiphan.casestudy.service.impl.person;

import daiphan.casestudy.dto.person.IEmployeeDto;
import daiphan.casestudy.model.person.Employee;
import daiphan.casestudy.repository.person.IEmployeeRepository;
import daiphan.casestudy.service.person.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee insert(Employee element) {
        return employeeRepository.save(element);
    }

    @Override
    public Employee update(Employee element) {
        return employeeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.deleteLogicById(id)==1;
    }

    @Override
    public Page<IEmployeeDto> find(String searchName, String searchAddress, String searchPosition, Pageable pageable) {
        return employeeRepository.find(searchName,searchAddress,searchPosition,pageable);
    }

    @Override
    public List<IEmployeeDto> findAllDto() {
        return employeeRepository.findAllDto();
    }
}
