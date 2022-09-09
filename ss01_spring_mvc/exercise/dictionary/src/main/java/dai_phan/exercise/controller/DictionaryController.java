package dai_phan.exercise.controller;

import dai_phan.exercise.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @Autowired
    private IService service;

    @PostMapping ("/")
    public ModelAndView getMean(@RequestParam String key) {
        return new ModelAndView("/dictionary", "mean", service.findKey(key));
    }

    @GetMapping("/")
    public ModelAndView getMean() {
        return new ModelAndView("/dictionary");
    }
}
