package com.example.validate_form_dang_ki.controller;

import com.example.validate_form_dang_ki.model.User;
import com.example.validate_form_dang_ki.validate.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserValidator userValidator;

    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("index","user", new User());
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        userValidator.validate(user,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("index");
        }
        return new ModelAndView("result","user",user);
    }
}
