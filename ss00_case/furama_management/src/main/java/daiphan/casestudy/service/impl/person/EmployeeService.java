package daiphan.casestudy.service.impl.person;

import daiphan.casestudy.model.person.Employee;
import daiphan.casestudy.repository.person.IEmployeeRepository;
import daiphan.casestudy.service.person.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return employeeRepository.getById(id);
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
        return employeeRepository.deleteLogicById(id);
    }
}
