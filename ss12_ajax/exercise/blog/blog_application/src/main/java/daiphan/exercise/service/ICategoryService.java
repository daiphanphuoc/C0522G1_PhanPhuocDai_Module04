package daiphan.exercise.service;

import daiphan.exercise.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

    void delete(int id);

    void update(Category category);

    Category insert(Category category);

    Category findById(int id);

    List<Category> searchByName(String search);
}
