package dai_phan.exercise.controller;

import dai_phan.exercise.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @PostMapping ("/")
    public ModelAndView getMean(@RequestParam String key) {
        return new ModelAndView("dictionary", "mean",
                dictionaryService.findKey(key));
    }

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("dictionary");
    }
}
