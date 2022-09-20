package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){
        String name="Ozzy";
        //method from model interface
        model.addAttribute("name", "Cydeo");

        return "student/welcome";
    }
}
