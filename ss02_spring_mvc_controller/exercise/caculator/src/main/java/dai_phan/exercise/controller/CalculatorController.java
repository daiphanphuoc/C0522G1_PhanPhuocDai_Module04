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
    ICalculatorService calculatorService;

    @RequestMapping("/")
    public String showCalculator() {
        return "index";
    }

    @RequestMapping("/calculator")
    public String showResult(@RequestParam double first, @RequestParam double second,
                             @RequestParam String calculator,Model model) {
        double result =0;
        switch (calculator){
            case "addition":
                result=calculatorService.addition(first,second);
                break;
            case "subtraction":
                result=calculatorService.subtraction(first,second);
                break;
            case "multiplication":
                result=calculatorService.multiplication(first,second);
                break;
            case "division":
                if (second!=0) {
                    result=calculatorService.division(first, second);
                }else{
                    model.addAttribute("result","vui lòng nhập số chia khác 0");
                    return "index";
                }
                break;
            default:model.addAttribute("result","vui lòng nhập số, phép tính");
                return "index";
        }
        model.addAttribute("result",result);
        return "index";
    }
}
