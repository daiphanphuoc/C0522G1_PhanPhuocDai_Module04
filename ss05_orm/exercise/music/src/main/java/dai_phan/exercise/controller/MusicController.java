package dai_phan.exercise.controller;

import dai_phan.exercise.model.Music;
import dai_phan.exercise.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @RequestMapping("")
    public String listMusic(Model model) {
        model.addAttribute("musicList", musicService.musicAll());
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String search, Model model) {
        model.addAttribute("musicList", musicService.searchByName(search));
        return "index";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.detail(id));
        return "update";
    }

    @GetMapping("/{id}/detail")
    public String showFormDetail(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.detail(id));
        return "detail";
    }

    @GetMapping("/{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.detail(id));
        return "delete";
    }

    @PostMapping("/save")
    public String insert(Music music, RedirectAttributes redirectAttributes) {
        music.setId((int) (Math.random() * 10000));
        musicService.insert(music);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/music";
    }

    @PostMapping("/update")
    public String update(Music music, RedirectAttributes redirectAttributes) {
        musicService.update(music);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/music";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirectAttributes) {
        musicService.delete(music);
        redirectAttributes.addFlashAttribute("success", "Xóa thành công bài  hát " + music.getName());
        return "redirect:/music";
    }
}

