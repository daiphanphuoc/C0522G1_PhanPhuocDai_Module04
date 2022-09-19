package daiphan.exercise.service.impl;

import daiphan.exercise.model.Blog;
import daiphan.exercise.model.Category;
import daiphan.exercise.repository.ICategoryRepository;
import daiphan.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Page<Category> searchByName(String search, Pageable pageable) {
        return categoryRepository.searchByName(search,pageable);
    }
}
