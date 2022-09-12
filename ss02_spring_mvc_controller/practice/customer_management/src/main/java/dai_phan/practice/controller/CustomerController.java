package dai_phan.practice.controller;

import dai_phan.practice.model.Customer;
import dai_phan.practice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customers/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/customers/update")
    public String updateCustomer(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address
    ) {
        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);
        return "redirect:/customers";
    }
}
