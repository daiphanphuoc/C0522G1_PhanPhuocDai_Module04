package daiphan.exercise.repository;

import daiphan.exercise.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}
