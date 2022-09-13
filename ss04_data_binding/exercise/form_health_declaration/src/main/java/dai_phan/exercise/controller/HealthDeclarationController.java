package dai_phan.exercise.controller;

import dai_phan.exercise.model.HealthDeclaration;
import dai_phan.exercise.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HealthDeclarationController {

    @Autowired
    private IHealthDeclarationService healthDeclarationService;


    @GetMapping("/health")
    public ModelAndView showList() {
        return new ModelAndView("/list", "list", healthDeclarationService.displayAll());
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/update");
        HealthDeclaration healthDeclaration = healthDeclarationService.finById(id);
        modelAndView.addObject("info", healthDeclaration);
        modelAndView.addObject("countryList", healthDeclarationService.countryList());
        modelAndView.addObject("travelInfo", healthDeclarationService.travelInfo());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        HealthDeclaration healthDeclaration = new HealthDeclaration();
        modelAndView.addObject("info", healthDeclaration);
        modelAndView.addObject("countryList", healthDeclarationService.countryList());
        modelAndView.addObject("travelInfo", healthDeclarationService.travelInfo());
        return modelAndView;
    }

    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute HealthDeclaration health, RedirectAttributes attributes) {
        HealthDeclaration healthDeclaration = healthDeclarationService.update(health);
        if (healthDeclaration != null) {
            attributes.addFlashAttribute("message", "Cập nhật thành công" + health.getName());
        } else {
            attributes.addFlashAttribute("message", "Cập nhật thất bại" + health.getName());
        }
        return "redirect:/health";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute HealthDeclaration health, RedirectAttributes attributes) {
        HealthDeclaration healthDeclaration = healthDeclarationService.insert(health);
        if (healthDeclaration != null) {
            attributes.addFlashAttribute("message", "Thêm mới thành công" + health.getName());
        } else {
            attributes.addFlashAttribute("message", "Thêm mới thất bại" + health.getName());
        }
        return "redirect:/health";
    }
}
