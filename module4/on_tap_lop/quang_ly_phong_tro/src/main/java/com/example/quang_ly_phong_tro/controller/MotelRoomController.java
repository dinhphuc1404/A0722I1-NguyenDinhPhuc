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
    public String search(@RequestParam("searchAll") String searchAll , Model model ) {
        List<MotelRoom> motelRooms = motelRoomService.findAllBySearchAll( searchAll, searchAll);
        model.addAttribute("searchAll", searchAll);
        model.addAttribute("motelRooms", motelRooms);
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
}
