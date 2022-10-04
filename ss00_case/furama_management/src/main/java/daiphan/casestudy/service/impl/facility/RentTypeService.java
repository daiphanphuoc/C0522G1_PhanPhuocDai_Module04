package daiphan.casestudy.service.impl.facility;

import daiphan.casestudy.model.facility.RentType;
import daiphan.casestudy.repository.facility.IRentTypeRepository;
import daiphan.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).get();
    }

    @Override
    public RentType insert(RentType element) {
        return rentTypeRepository.save(element);
    }

    @Override
    public RentType update(RentType element) {
        return rentTypeRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return rentTypeRepository.deleteLogicById(id);
    }
}
