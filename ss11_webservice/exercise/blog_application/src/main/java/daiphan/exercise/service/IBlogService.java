package daiphan.exercise.service;

import daiphan.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    Page<Blog> searchByTitle(String title, Pageable pageable);

    List<Blog> searchByTitle(String title);

    Blog findById(int id);

    Blog insert(Blog blog);

    Blog update(Blog blog);

    int delete(int id);
}
