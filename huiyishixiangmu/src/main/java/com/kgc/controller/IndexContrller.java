package com.kgc.controller;

import com.kgc.entity.Meetingroom;
import com.kgc.service.MeetingroomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexContrller {
    @Resource
    MeetingroomService meetingroomService;
    @RequestMapping("/")
    public String index(Model model, HttpSession session){
        List<Meetingroom> meetingrooms = meetingroomService.selectAll();
        model.addAttribute("meetingrooms",meetingrooms);
        return "index";
    }
    @RequestMapping("/addjin")
    public String addjin(Meetingroom meetingroom){
        return "add";
}
    @RequestMapping("/add")
    public String add(Meetingroom meetingroom){
            meetingroomService.add(meetingroom);
            return "redirect:/";
        }
    }

