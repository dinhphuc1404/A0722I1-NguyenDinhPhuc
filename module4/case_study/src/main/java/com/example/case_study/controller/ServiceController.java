package com.example.case_study.controller;

import com.example.case_study.entity.RentType;
import com.example.case_study.entity.Service;
import com.example.case_study.entity.ServiceType;
import com.example.case_study.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    IServiceService serviceService;

    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceTypes(){
        return serviceService.findAllServiceType();
    }

    @ModelAttribute("rentTypes")
    public List<RentType> rentTypes(){
        return serviceService.findAllRentType();
    }

    @GetMapping("")
    public ModelAndView listService(){
        return new ModelAndView("service/list","serviceList",serviceService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("service/create","service",new Service());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("service") Service service){
        serviceService.save(service);
        return "redirect:/service/";
    }
}
