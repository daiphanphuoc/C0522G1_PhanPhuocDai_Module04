package daiphan.exercise.controller;

import daiphan.exercise.dto.MusicDto;
import daiphan.exercise.model.Music;
import daiphan.exercise.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String home(@PageableDefault(value = 3) Pageable pageable, Model model,
                       @RequestParam(defaultValue = "") String search) {
        model.addAttribute("musicList", musicService.findByName(search, pageable));
        model.addAttribute("search", search);
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/create";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable int id, Model model) {
        Music music = musicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "/update";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Thêm mới bài hát: " + music.getMusicName() + " Thành công !");
            return "redirect:/music";
        }
    }

    @PostMapping("/update")
    public String update(MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "/update";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "cập nhập bài hát: " + music.getMusicName() + " Thành công !");
            return "redirect:/music";
        }
    }
}

