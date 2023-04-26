package com.example.upload_file.controller;

import com.example.upload_file.entity.User;
import com.example.upload_file.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/list")
    public String list(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "users/list";
    }
    @GetMapping(value = "/create")
    public String viewCreate(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "/users/create";
    }
    @PostMapping(value = "/create")
    public String create(@ModelAttribute("user") User user, Model model, @RequestParam("img") MultipartFile image){
        Path path = Paths.get("upload/");
        try {
            InputStream inputStream = image.getInputStream();
            Files.copy(inputStream,path.resolve(image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            user.setImage(image.getOriginalFilename().toLowerCase());

        } catch (IOException e) {
            e.printStackTrace();
        }
        userService.create(user);
        return "redirect:/user/list";
    }
}
