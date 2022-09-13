package dai_phan.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/abc")
public class AbcController {

    @GetMapping("/a")
    public String goAbc() {
        return "index";
    }
}
