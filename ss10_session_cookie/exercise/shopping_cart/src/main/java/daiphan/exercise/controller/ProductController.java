package daiphan.exercise.controller;

import daiphan.exercise.dto.CartDto;
import daiphan.exercise.dto.ProductDto;
import daiphan.exercise.model.Product;
import daiphan.exercise.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping("")
    public ModelAndView showShop(@CookieValue(value = "idProduct", defaultValue = "-1") int idProduct, Model model) {
        ModelAndView modelAndView = new ModelAndView("shop/shop");
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showProduct(@PathVariable int id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        ModelAndView modelAndView = new ModelAndView("shop/detail");
        modelAndView.addObject("product", productService.findById(id));
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute("cart") CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error.404";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOptional.get(), productDto);
        cart.addProduct(productDto);
        return "redirect:/card";

    }
}
