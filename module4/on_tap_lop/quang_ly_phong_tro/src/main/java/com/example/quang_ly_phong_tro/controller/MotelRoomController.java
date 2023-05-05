package com.example.quang_ly_phong_tro.controller;

import com.example.quang_ly_phong_tro.entity.MotelRoom;
import com.example.quang_ly_phong_tro.entity.Pay;
import com.example.quang_ly_phong_tro.service.MotelRoomService;
import com.example.quang_ly_phong_tro.service.PayService;
import com.example.quang_ly_phong_tro.validate.MotelRoomValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/room")
public class MotelRoomController {
    @Autowired
    private MotelRoomService motelRoomService;

    @Autowired
    PayService payService;

    @Autowired
    private MotelRoomValidate validate;

    @GetMapping("/list")
    public String listpagingslice(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Slice<MotelRoom> motelRooms = motelRoomService.findAllWithSlice(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("motelRooms", motelRooms.getContent());
        model.addAttribute("page", motelRooms);
        return "room/list";
    }
    @GetMapping( "/search")
    public String search(@RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size, @RequestParam("searchAll") String searchAll , Model model ) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        model.addAttribute("searchAll", searchAll);
        Slice<MotelRoom> motelRooms = motelRoomService.findAllBySearchAll( searchAll, searchAll,PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("motelRooms", motelRooms.getContent());
        model.addAttribute("page", motelRooms);
        return "room/list";
    }





    @GetMapping("/create")
    public String viewCreate(Model model) {
        List<Pay> pays = payService.findAll();
        MotelRoom motelRoom = new MotelRoom();
        motelRoom.setPayName(new Pay());
        model.addAttribute("room", motelRoom);
        model.addAttribute("pays", pays);
        return "/room/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("room") MotelRoom motelRoom,
                         BindingResult bindingResult, Model model) {
        validate.validate(motelRoom, bindingResult);
        if (bindingResult.hasErrors()) {
            List<Pay> pays = payService.findAll();
            model.addAttribute("pays", pays);
            if (motelRoom.getPayName() == null) {
                motelRoom.setPayName(new Pay());
            }
            return "/room/create";
        }
        motelRoomService.create(motelRoom);
        return "redirect:/room/list";
    }
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") MotelRoom motelRoom, Model model) {
        List<Pay> pays = payService.findAll();
        model.addAttribute("pays", pays);
        model.addAttribute("room", motelRoom);
        return "/room/update";
    }

    @PostMapping("/update")
    public String update(@Valid@ModelAttribute("room")  MotelRoom motelRoom,BindingResult bindingResult,Model model){
        validate.validate(motelRoom, bindingResult);
        if (bindingResult.hasErrors()) {
            List<Pay> pays = payService.findAll();
            model.addAttribute("pays", pays);
            if (motelRoom.getPayName() == null) {
                motelRoom.setPayName(new Pay());
            }
            return "/room/update";
        }
        motelRoomService.update(motelRoom);
        return "redirect:/room/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
       motelRoomService.delete(id);
        return "redirect:/room/list";
    }

//    @GetMapping(value = "/deleteAll")
//    public String deleteAll(@RequestParam("ids") Integer[] ids) {
//        motelRoomService.deleteAll(ids);
//        return "redirect:/room/list";
//    }

    @PostMapping("/deleteAll")
    public String doDeleteAll(@RequestParam("ids") Integer[] ids, Model model, RedirectAttributes redirect) {
        for (Integer no : ids) {
            motelRoomService.delete(no);
            redirect.addFlashAttribute("message", "Removed successfully!");
        }
        return "redirect:/room/list";
    }


    @GetMapping("/view")
    public String showViewForm(@RequestParam("id") Integer id,  Model model) {
        MotelRoom motelRoom = motelRoomService.findById(id);
        model.addAttribute("room", motelRoom);
        return "/room/view";
    }

//    @GetMapping("/view/{id}")
//    public String view(@PathVariable("id") MotelRoom motelRoom, Model model) {
//        model.addAttribute("room", model);
//        return "/room/view";
//    }
}
