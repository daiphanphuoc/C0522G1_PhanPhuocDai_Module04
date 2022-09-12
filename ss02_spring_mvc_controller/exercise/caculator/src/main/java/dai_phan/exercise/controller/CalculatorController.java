package dai_phan.exercise.controller;

import dai_phan.exercise.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @RequestMapping("/")
    public String showCalculator() {
        return "index";
    }

    @RequestMapping("/calculator")
    public String showResult(@RequestParam String first, @RequestParam String second,
                             @RequestParam String calculator, Model model) {
        String result = calculatorService.calculate(first,second,calculator);

        model.addAttribute("result", result);
        return "index";
    }
}
