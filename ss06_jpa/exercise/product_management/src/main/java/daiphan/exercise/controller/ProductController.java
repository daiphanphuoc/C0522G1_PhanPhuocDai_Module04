package daiphan.exercise.controller;

import daiphan.exercise.model.Product;
import daiphan.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

   /* @RequestMapping("")
    public String listProduct(Model model) {
        model.addAttribute("products", productService.productAll());
        return "index";
    }
*/
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @GetMapping("")
    public String searchByName(@RequestParam(defaultValue = "") String search, Model model) {
        model.addAttribute("products", productService.searchByName(search));
        return "index";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.detail(id));
        return "update";
    }

    @GetMapping("/{id}/detail")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.detail(id));
        return "detail";
    }

    @GetMapping("/{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.detail(id));
        return "delete";
    }

    @PostMapping("/save")
    public String insert(Product product, RedirectAttributes redirectAttributes) {
        //product.setId((int) (Math.random() * 10000));
        Product p = productService.insert(product);
        if(p!=null) {
            redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        }
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.delete(product.getId());
        redirectAttributes.addFlashAttribute("success", "Xóa thành công sản phẩm " + product.getName());
        return "redirect:/product";
    }
}

