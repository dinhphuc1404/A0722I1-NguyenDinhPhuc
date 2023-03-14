package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.entity.EmailConfig;
import com.example.hom_thu_dien_tu.entity.ListLanguages;
import com.example.hom_thu_dien_tu.entity.ListPageSize;
import com.example.hom_thu_dien_tu.repository.EmailConfigRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    EmailConfigRepositories emailConfigRepositories = new EmailConfigRepositories();

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listLanguages", ListLanguages.languages());
        modelAndView.addObject("listPageSize", ListPageSize.pageSizes());
        modelAndView.addObject("emailConfig",emailConfigRepositories.getEmailConfig());
        return modelAndView;
    }

    @PostMapping("/save")
    public String submitForm(@ModelAttribute("emailConfig") EmailConfig emailConfig){
        emailConfigRepositories.setEmailConfig(emailConfig);
        return "redirect:/";
    }
}
