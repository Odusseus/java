package org.odusseus.Defteros.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class WelcomeController {

  @RequestMapping("/welcome")
    public String welcome() {
        System.out.println("Going home...");
        return "welcome";
    }    
}

