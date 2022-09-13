package dai_phan.exercise.service.impl;

import dai_phan.exercise.model.HealthDeclaration;
import dai_phan.exercise.repository.IHealthDeclarationRepository;
import dai_phan.exercise.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthDeclarationService implements IHealthDeclarationService {

    @Autowired
    private IHealthDeclarationRepository healthDeclarationRepository;

    @Override
    public List<HealthDeclaration> displayAll() {
        return new ArrayList<>(healthDeclarationRepository.displayAll().values());
    }

    @Override
    public HealthDeclaration finById(int id) {
        return healthDeclarationRepository.finById(id);
    }

    @Override
    public HealthDeclaration update(HealthDeclaration healthDeclaration) {
        return healthDeclarationRepository.update(healthDeclaration);
    }

    @Override
    public HealthDeclaration insert(HealthDeclaration healthDeclaration) {
        return healthDeclarationRepository.insert(healthDeclaration);
    }

    @Override
    public List<String> countryList() {
        return healthDeclarationRepository.countryList();
    }

    @Override
    public List<String> travelInfo() {
        return healthDeclarationRepository.travelInfo();
    }
}
