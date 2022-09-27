package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        //method from model interface
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        String subject="Spring Boot";
        model.addAttribute("subject",subject);

        int studentId= new Random().nextInt();
        model.addAttribute("id", studentId);


        ArrayList<Integer> numbers= new ArrayList<>();
        numbers.add(1);
        numbers.add(4);
        numbers.add(6);

        model.addAttribute("Numbers", numbers);

        LocalDate dt= LocalDate.now();

        model.addAttribute("Date", dt);

        Student student= new Student(1,"mike", "Smith");
        model.addAttribute("student", student);
        return "student/welcome";
    }
}
