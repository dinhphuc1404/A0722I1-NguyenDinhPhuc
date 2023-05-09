package com.example.final_exam.controller;

import com.example.final_exam.entity.DoanhNghiep;
import com.example.final_exam.entity.DuAn;
import com.example.final_exam.service.DoanhNghiepService;
import com.example.final_exam.service.DuAnService;
import com.example.final_exam.validate.IdValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/duAn")
public class DuAnController {
    @Autowired
    private IdValidate idValidate;
    @Autowired
    private DuAnService duAnService;

    @Autowired
    private DoanhNghiepService doanhNghiepService;

    @GetMapping("/list")
    public String listpagingslice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Slice<DuAn> duAns = duAnService.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("duAns", duAns.getContent());
        model.addAttribute("page", duAns);
        return "duAn/list";
    }

//    @GetMapping("/create")
//    public String viewCreate(Model model) {
//        LocalDate localDate = LocalDate.now();
//        List<DoanhNghiep> doanhNghieps = doanhNghiepService.findAll();
//        DuAn duAn = new DuAn();
//        duAn.setNgayDangKy(String.valueOf(localDate));
//        duAn.setDoanhNghiep(new DoanhNghiep());
//        model.addAttribute("duAn", duAn);
//        model.addAttribute("doanhNghieps", doanhNghieps);
//        return "/duAn/create";
//    }
//
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("duAn") DuAn duAn,
                         BindingResult bindingResult, Model model) {
        idValidate.validate(duAn,bindingResult);
        if (bindingResult.hasErrors()) {
            List<DoanhNghiep> doanhNghieps = doanhNghiepService.findAll();
            model.addAttribute("listDoanhNghiep", doanhNghieps);
            if (duAn.getDoanhNghiep() == null) {
                duAn.setDoanhNghiep(new DoanhNghiep());
            }
            return "/duAn/create";
        }
        duAnService.create(duAn);
        return "redirect:/duAn/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model){
        DuAn duAn = new DuAn();
        LocalDate localDate = LocalDate.now();
        duAn.setNgayDangKy(String.valueOf(localDate));
        model.addAttribute("listDoanhNghiep", doanhNghiepService.findAll());
        model.addAttribute("duAn",duAn);
        return "/duAN/create";
    }

    @GetMapping("/view")
    public String showViewForm(@RequestParam("maDuAn") String id,  Model model) {
        DuAn duAn = duAnService.findById(id);
        model.addAttribute("duAn", duAn);
        return "/duAn/view";
    }



}
