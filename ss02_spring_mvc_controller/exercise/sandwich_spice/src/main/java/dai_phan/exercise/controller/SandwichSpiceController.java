package dai_phan.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichSpiceController {
    @RequestMapping
    public String home() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(Model model, @RequestParam(value = "condiments", defaultValue = "") String[] condiments) {
        if (condiments.length == 0) {
            model.addAttribute("condiments", "Bạn chưa chọn gia vị");
        } else {
            model.addAttribute("condiments", condiments);
        }
        return "index";
    }
}
