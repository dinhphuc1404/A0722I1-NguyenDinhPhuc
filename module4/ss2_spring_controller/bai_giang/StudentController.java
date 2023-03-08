package codegym.vn.controller;

import codegym.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    // constructor injection
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list"
//            , consumes = {MediaType.APPLICATION_JSON_VALUE}
//            , produces = {MediaType.APPLICATION_JSON_VALUE}
            , headers = {"Content-Type=json"}
            )
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @RequestMapping(value = {"/list2", "/"}, method = RequestMethod.GET)
    public String displayList2(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/detail/{id}/{name}")
    public String detail(@PathVariable(name = "id") String id,
                         @PathVariable(name = "name") String name,
                         Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") String id,
                         Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    // setter injection
//    @Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }
}
