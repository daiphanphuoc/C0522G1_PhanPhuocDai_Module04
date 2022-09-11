package dai_phan.exercise.controller;

import dai_phan.exercise.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {

    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("/form");
    }

    @GetMapping("/form")
    public ModelAndView showResult(@RequestParam String usd) {
        double result=0;
        if (usd.length()>0) {
            result = currencyService.convertUsdToVnd(Double.parseDouble(usd));
        }
        return new ModelAndView("form", "result", result);
    }
}
