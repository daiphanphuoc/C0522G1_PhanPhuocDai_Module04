package daiphan.exercise.controller;

import daiphan.exercise.dto.UserDto;
import daiphan.exercise.model.User;
import daiphan.exercise.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(value = 2) Pageable pageable,
                           @RequestParam(defaultValue = "") String search) {
        model.addAttribute("users", iUserService.findAll(pageable));
        model.addAttribute("search", search);
        return "index";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("mess", "Add new User successful!!");
        }
        return "redirect:/user";
    }
}
