package com.example.quan_ly_dien_thoai.controller;

import com.example.quan_ly_dien_thoai.model.SmartPhone;
import com.example.quan_ly_dien_thoai.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/phones")
public class SmartPhoneController {
    @Autowired
    SmartPhoneService smartPhoneService;

    @RequestMapping(value = "/api",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SmartPhone> allPhone(){
        return smartPhoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage(){
        return new ModelAndView("phones/all-phones", "allPhones",allPhone());
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView createSmartphonePage(){
        return new ModelAndView("phones/new-phone","sPhone",new SmartPhone());
    }

    @RequestMapping(value = "/create-new-phone" , method = RequestMethod.POST
            ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone createSmartPhone(@RequestBody SmartPhone smartPhone){
        return smartPhoneService.save(smartPhone);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
            ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone deleteSmartPhone(@PathVariable("id") Integer id){
        return smartPhoneService.remove(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editSmartPhonePage(@PathVariable("id") Integer id){
        return new ModelAndView("phones/edit-phones","sPhone",smartPhoneService.findById(id));
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
            ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SmartPhone editSmartPhone(@PathVariable("id") Integer id, @RequestBody SmartPhone smartPhone){
        smartPhone.setId(id);
        return smartPhoneService.save(smartPhone);
    }

}

