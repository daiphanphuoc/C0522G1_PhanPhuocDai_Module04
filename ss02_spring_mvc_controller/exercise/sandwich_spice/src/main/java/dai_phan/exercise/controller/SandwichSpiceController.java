package dai_phan.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichSpiceController {
    @RequestMapping
    public String home(){
        return "index";
    }

    @RequestMapping("/save")
    public String save(Model model, @RequestParam("condiments") String[] condiments) {

        model.addAttribute("condiments",condiments);
        return "index";
    }
}
