package daiphan.exercise.service.impl;

import daiphan.exercise.model.Blog;
import daiphan.exercise.repository.IBlogRepository;
import daiphan.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository repository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchByTitle(String title, Pageable pageable) {
        return repository.searchByTitle(title, pageable);
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
