package daiphan.exercise.controller;

import daiphan.exercise.dto.CategoryDto;
import daiphan.exercise.model.Category;
import daiphan.exercise.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category/v1")
@CrossOrigin("*")
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;


    @GetMapping("")
    public ResponseEntity<List<Category>> searchByName(@RequestParam(defaultValue = "") String search) {
        List<Category> category = categoryService.searchByName(search);
        if (category.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> showDetail(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity insert(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.insert(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.update(category);

        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}


