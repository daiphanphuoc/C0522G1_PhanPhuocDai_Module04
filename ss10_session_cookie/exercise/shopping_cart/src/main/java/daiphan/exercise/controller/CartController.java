package daiphan.exercise.controller;

import daiphan.exercise.dto.CartDto;
import daiphan.exercise.dto.ProductDto;
import daiphan.exercise.model.Product;
import daiphan.exercise.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/card")
public class CartController {

    @Autowired
    private IProductService productService;


    @GetMapping("")
    public ModelAndView showCart (@SessionAttribute(value = "cart",required = false) CartDto cart){
        ModelAndView modelAndView = new ModelAndView("cart/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/reduce/{id}")
    public String reduceToCart(@PathVariable int id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto product =new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),product);
            cart.reduceProduct(product);
        }
        return "cart/cart";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id, @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto product =new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),product);
            cart.addProduct(product);
        }
        return "cart/cart";
    }
}
