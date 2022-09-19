package daiphan.exercise.controller;

import daiphan.exercise.model.Category;
import daiphan.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;

/*
    @RequestMapping("")
    public String showList(Model model, @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("categoryList", categoryService.findAll(pageable));
        return "category/index";
    }
*/


    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @GetMapping("")
    public String searchByName(@RequestParam(defaultValue = "") String search, Model model,
                               @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("categoryList", categoryService.searchByName(search, pageable));
        model.addAttribute("search", search);
        return "category/index";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }

    @GetMapping("/{id}/detail")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/detail";
    }

    @GetMapping("/{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/delete";
    }

    @PostMapping("/save")
    public String insert(Category category, RedirectAttributes redirectAttributes) {
        //product.setId((int) (Math.random() * 10000));
        Category temp = categoryService.insert(category);
        if (temp != null) {
            redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        }
        return "redirect:/category";
    }

    @PostMapping("/update")
    public String update(Category category, RedirectAttributes redirectAttributes) {
        categoryService.update(category);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/category";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirectAttributes) {
        categoryService.delete(category.getId());
        redirectAttributes.addFlashAttribute("success", "Xóa thành công  " + category.getNameCategory());
        return "redirect:/category";
    }

}


