package daiphan.exercise.controller;

import daiphan.exercise.dto.BlogDto;
import daiphan.exercise.dto.IBlogDto;
import daiphan.exercise.model.Blog;
import daiphan.exercise.service.IBlogDtoService;
import daiphan.exercise.service.IBlogService;
import daiphan.exercise.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/blog/v1")
@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogDtoService blogDtoService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> searchByName(@RequestParam(defaultValue = "") String search) {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<IBlogDto>> searchByNameDto(@RequestParam(defaultValue = "") String search) {
        List<IBlogDto> blogs = blogDtoService.searchByTitle(search);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id, @RequestBody BlogDto blogDto) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(blogDto, blog);
        blogService.update(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity showFormDelete(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        blogService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Blog> insert(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        Blog p = blogService.insert(blog);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
