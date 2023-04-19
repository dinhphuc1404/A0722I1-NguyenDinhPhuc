package com.example.student.controller;

import com.example.student.entity.ClassName;
import com.example.student.entity.Student;
import com.example.student.service.ClassNameService;
import com.example.student.service.StudentService;
import com.example.student.validate.StudentValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private ClassNameService classNameService;

    @Autowired
    private StudentValidate validate;
    @GetMapping(value = "/list")
    public String listpagingslice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Slice<Student> students = service.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("students", students.getContent());
        model.addAttribute("page", students);
        return "student/list";
    }

    @GetMapping(value = "/deleteAll")
    public String delete(@RequestParam("ids") String[] ids) {
        service.deleteAll(ids);
        return "redirect:/student/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<ClassName> classNames = classNameService.findAll();
        Student student = new Student();
        student.setClassName(new ClassName());
        model.addAttribute("student", student);
        model.addAttribute("classNames", classNames);
        return "/student/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("student") Student student,
                         BindingResult bindingResult, Model model) {
        validate.validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            List<ClassName> classNames = classNameService.findAll();
            model.addAttribute("classNames", classNames);
            if (student.getClassName() == null) {
                student.setClassName(new ClassName());
            }
            return "/student/create";
        }
        service.create(student);
        return "redirect:/student/list";
    }

    @GetMapping("/update/{student_id}")
    public String updateStudent(@PathVariable("student_id") Student student, Model model) {
        List<ClassName> classNames = classNameService.findAll();
        model.addAttribute("classNames", classNames);
        model.addAttribute("student", student);
        return "/student/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("student")  Student student,BindingResult bindingResult,Model model){
//        validate.validate(student, bindingResult);
//        if (bindingResult.hasErrors()) {
//            List<ClassName> classNames = classNameService.findAll();
//            model.addAttribute("classNames", classNames);
//            if (student.getClassName() == null) {
//                student.setClassName(new ClassName());
//            }
//            return "/student/update";
//        }
        service.update(student);
        return "redirect:/student/list";
    }
}
