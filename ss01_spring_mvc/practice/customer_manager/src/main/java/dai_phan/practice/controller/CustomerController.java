package dai_phan.practice.controller;

import dai_phan.practice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService service;
    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("/list", "customers", service.findAll());
    }

    @GetMapping("/customer")
    public ModelAndView showElement(@RequestParam String id){
        return new ModelAndView("/customer", "customer", service.findId(id));
    }
}
