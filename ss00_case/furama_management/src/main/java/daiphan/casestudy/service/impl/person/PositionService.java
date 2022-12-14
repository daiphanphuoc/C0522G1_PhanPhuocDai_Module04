package daiphan.casestudy.service.impl.person;

import daiphan.casestudy.model.person.Position;
import daiphan.casestudy.repository.person.IPositionRepository;
import daiphan.casestudy.service.person.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Position findById(int id) {
        return positionRepository.getById(id);
    }

    @Override
    public Position insert(Position element) {
        return positionRepository.save(element);
    }

    @Override
    public Position update(Position element) {
        return positionRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return positionRepository.deleteLogicById(id);
    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
