package com.example.student.controler;

import com.example.student.entity.ClassName;
import com.example.student.entity.Student;
import com.example.student.service.ClassNameService;
import com.example.student.service.StudentService;
import com.example.student.validate.StudentValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private ClassNameService classNameService;

    @GetMapping(value = "/list")
    public String list(Model model){
        List<Student> students = service.findAll();
        model.addAttribute("students",students);
        return"student/list";
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
        StudentValidate validate = new StudentValidate();
        validate.setService(service);
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
    @GetMapping("/view/{student_id}")
    public String viewStudent(@PathVariable("student_id") Student student, Model model) {
        model.addAttribute("student", student);
        return "/student/view";
    }
    @GetMapping("/view")
    public String viewStudentByParam(@RequestParam("id") String id, Model model) {
        Student student = service.findById(id);
        model.addAttribute("student", student);
        return "/student/view";
    }
}
