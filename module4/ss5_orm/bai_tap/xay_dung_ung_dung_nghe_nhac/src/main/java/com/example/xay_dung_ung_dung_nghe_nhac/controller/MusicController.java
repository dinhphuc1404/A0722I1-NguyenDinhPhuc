package com.example.xay_dung_ung_dung_nghe_nhac.controller;

import com.example.xay_dung_ung_dung_nghe_nhac.entity.Music;
import com.example.xay_dung_ung_dung_nghe_nhac.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("musics", musicService.findAll());
        return "music/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        Music music = new Music();
        model.addAttribute("music", music);
        return "music/create";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute(name = "music") Music music, Model model, RedirectAttributes rd) {
        musicService.create(music);
        //rd.addFlashAttribute("message", "Thêm mới student thành công");
        return "redirect:/music/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdate( @PathVariable("id") int id, Model model){
        model.addAttribute("music",musicService.findById(id));
        return "music/update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute(name = "music") Music music, Model model, RedirectAttributes rd) {
        musicService.update(music);
        //rd.addFlashAttribute("message", "Thêm mới student thành công");
        return "redirect:/music/list";
    }

    @GetMapping("/delete/{id}")
    public String delete( @PathVariable("id") int id, Model model){
        model.addAttribute("music",musicService.findById(id));
        musicService.delete(id);
        return "redirect:/music/list";
    }




}
