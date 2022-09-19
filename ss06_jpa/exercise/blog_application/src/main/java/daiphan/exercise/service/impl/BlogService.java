package daiphan.exercise.service.impl;

import daiphan.exercise.model.Blog;
import daiphan.exercise.repository.IBlogRepository;
import daiphan.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Blog> searchByTitle(String title) {
        return repository.searchByTitle(title);
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Blog insert(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public Blog update(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public int delete(int id) {
        return repository.deleteLogic(id);
    }
}
