package daiphan.exercise.service.impl;

import daiphan.exercise.model.Smartphone;
import daiphan.exercise.repository.ISmartphoneRepository;
import daiphan.exercise.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService<Smartphone> {

    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(int id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartphoneRepository.save(smartPhone);
    }

    @Override
    public void remove(int id) {
        smartphoneRepository.deleteById(id);
    }
}
