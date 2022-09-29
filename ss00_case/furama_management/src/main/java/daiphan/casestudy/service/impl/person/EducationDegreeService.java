package daiphan.casestudy.service.impl.person;

import daiphan.casestudy.model.person.EducationDegree;
import daiphan.casestudy.repository.person.IEducationDegreeRepository;
import daiphan.casestudy.service.person.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository degreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return degreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return degreeRepository.getById(id);
    }

    @Override
    public EducationDegree insert(EducationDegree element) {
        return degreeRepository.save(element);
    }

    @Override
    public EducationDegree update(EducationDegree element) {
        return degreeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return degreeRepository.deleteLogicById(id);
    }
}
