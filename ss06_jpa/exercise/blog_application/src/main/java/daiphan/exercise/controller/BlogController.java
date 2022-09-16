package daiphan.exercise.controller;

import daiphan.exercise.model.Blog;
import daiphan.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @RequestMapping("")
    public String showList(Model model){
        model.addAttribute("blogList",blogService.findAll() );
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String search, Model model) {
        model.addAttribute("blogList", blogService.searchByTitle(search));
        return "index";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
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
        if(p!=null) {
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
