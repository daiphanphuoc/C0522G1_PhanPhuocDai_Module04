package daiphan.exercise.service;

import daiphan.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> searchByTitle(String title, Pageable pageable);

    Blog findById(int id);

    Blog insert(Blog blog);

    Blog update(Blog blog);

    int delete(int id);
}
