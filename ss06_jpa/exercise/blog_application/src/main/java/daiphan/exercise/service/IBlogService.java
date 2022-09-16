package daiphan.exercise.service;

import daiphan.exercise.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    List<Blog> searchByTitle(String title);

    Blog findById( int id);

    Blog insert(Blog blog);

    Blog update(Blog blog);

    int delete(int id);
}
