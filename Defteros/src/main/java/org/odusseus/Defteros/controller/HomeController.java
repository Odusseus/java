package org.odusseus.Defteros.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

  @RequestMapping("/")
    public String home() {
        System.out.println("Going home...");
        return "home";
    }    
}

