package dai_phan.exercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("/form");
    }

    @GetMapping("/form")
    public ModelAndView showResult(@RequestParam String usd) {
        double result=0;
        if (usd.length()>0) {
            result = 23000 * Double.parseDouble(usd);
        }
        return new ModelAndView("/form", "result", result);
    }
}
