package daiphan.exercise.controller;

import daiphan.exercise.model.Blog;
import daiphan.exercise.repository.ICategoryRepository;
import daiphan.exercise.service.IBlogService;
import daiphan.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

/*    @RequestMapping("")
    public String showList(Model model, @PageableDefault(value = 3)Pageable pageable) {
        model.addAttribute("blogList", blogService.findAll(pageable));
        return "index";
    }*/

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", categoryService.findAll());
        return "create";
    }

    @GetMapping("")
    public String searchByName(@RequestParam(defaultValue = "") String search, Model model,
                               @PageableDefault(value = 3)Pageable pageable) {
        model.addAttribute("blogList", blogService.searchByTitle(search,pageable));
        model.addAttribute("search", search);
        return "index";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "update";
    }

    @GetMapping("/{id}/detail")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "detail";
    }

    @GetMapping("/{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }

    @PostMapping("/save")
    public String insert(Blog blog, RedirectAttributes redirectAttributes) {
        //product.setId((int) (Math.random() * 10000));
        Blog p = blogService.insert(blog);
        if (p != null) {
            redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        }
        return "redirect:/blog";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.delete(blog.getId());
        redirectAttributes.addFlashAttribute("success", "Xóa thành công  " + blog.getTitle());
        return "redirect:/blog";
    }

}
