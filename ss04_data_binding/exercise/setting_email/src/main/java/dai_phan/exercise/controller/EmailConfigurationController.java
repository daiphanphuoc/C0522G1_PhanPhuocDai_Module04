package dai_phan.exercise.controller;

import dai_phan.exercise.model.EmailConfiguration;
import dai_phan.exercise.service.IEmailConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailConfigurationController {

    @Autowired
    private IEmailConfigurationService emailService;

    @RequestMapping("/")
    public String showList(Model model) {
        List<EmailConfiguration> emailList = emailService.findAll();
        model.addAttribute("emailList", emailList);
        return "index";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showForm(@PathVariable int id, Model model) {
        EmailConfiguration email = emailService.findId(id);
        model.addAttribute("email", email);
        model.addAttribute("languageList", emailService.findLanguages());
        model.addAttribute("pageSizeList", emailService.findPages());
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute EmailConfiguration email, RedirectAttributes redirectAttributes) {
        emailService.update(email);
        redirectAttributes.addFlashAttribute("mess", "Update thành công");

        return "redirect:/email/";
    }
}
