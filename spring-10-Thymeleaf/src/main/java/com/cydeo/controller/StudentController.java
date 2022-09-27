package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    // CAN NOW USE THE ONE BELOW @RequestMapping("/register", method= RequestMethod.GET) // localhost:8080/student/register
   @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("students", DataGenerator.createStudent());
      //  model.addAttribute("mentors",DataGenerator.createMentor());

        return "student/register";
    }
    @RequestMapping("/welcome")
    public String welcome( ){
       // System.out.println(name);
        return "student/welcome";
    }

}
