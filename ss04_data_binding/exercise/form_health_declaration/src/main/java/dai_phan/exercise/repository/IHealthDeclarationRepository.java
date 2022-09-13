package dai_phan.exercise.repository;

import dai_phan.exercise.model.HealthDeclaration;

import java.util.List;
import java.util.Map;

public interface IHealthDeclarationRepository {

    Map<Integer, HealthDeclaration> displayAll();

    HealthDeclaration finById(int id);

    HealthDeclaration update(HealthDeclaration healthDeclaration);

    HealthDeclaration insert(HealthDeclaration healthDeclaration);

    List<String> countryList();

    List<String> travelInfo();
}
