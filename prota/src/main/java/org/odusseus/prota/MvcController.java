package org.odusseus.prota;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
 
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
 
@Controller
public class MvcController {

    private Users users;

    MvcController(){
        this.users = new Users(); 
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("Going home...");
        return "index";
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");
     
        model.addAttribute("user", user);
        model.addAttribute("professionList", professionList);
     
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

        System.out.println(user);

        this.users.addName(user);

        List<User> users = this.users.getUsers();
        model.addAttribute("users", users);
        //model.addAttribut("users", users);

        System.out.println(users);

        return "register_success";
    }
}
