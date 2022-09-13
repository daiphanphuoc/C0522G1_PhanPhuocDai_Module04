package dai_phan.exercise.service;

import dai_phan.exercise.model.HealthDeclaration;

import java.util.List;

public interface IHealthDeclarationService {

    List<HealthDeclaration> displayAll();

    HealthDeclaration finById(int id);

    HealthDeclaration update(HealthDeclaration healthDeclaration);

    HealthDeclaration insert(HealthDeclaration healthDeclaration);

    List<String> countryList();

    List<String> travelInfo();
}
