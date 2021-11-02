package dev.xeo.srrtplanner.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")

    public String home(Model theModel) {

        theModel.addAttribute("theDate", new java.util.Date());
        return "home";
    }

}
