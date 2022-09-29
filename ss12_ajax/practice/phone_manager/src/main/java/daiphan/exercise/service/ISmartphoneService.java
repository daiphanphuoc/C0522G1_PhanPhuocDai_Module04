package daiphan.exercise.service;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService<T> {
    List<T> findAll();

    Optional<T> findById(int id);

    T save(T smartPhone);

    void remove(int id);
}
