package org.odusseus.Defteros.controller;

import org.odusseus.Defteros.UserService;
import org.odusseus.Defteros.entity.User;
import org.odusseus.Defteros.entity.Users;
import org.odusseus.Defteros.logic.UserLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class UserController {
  
  private final UserService userService;
  
  @Autowired
  public UserController(UserService userService) {
     this.userService = userService;
   }
  
  @Autowired
  UserLogic UserLogic = new UserLogic();  

  @RequestMapping("/users")
  public String Users(Model model) {
    
    Users users = this.UserLogic.getUsers();
    
    model.addAttribute("users", users);		
    
    return "user/users";
  }

  @RequestMapping("/user/new")
  public String newUser(Model model) {
    
    User user = new User();		
    model.addAttribute("user", user);		
    
    return "user/new_user_form";
  }

  @RequestMapping("/user/save")
  public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

    if(bindingResult.hasErrors()){
      return "user/new_user_form";
    }

    boolean hasExists = this.UserLogic.getUsers().hasExistsIgnoreCase(user.getName());
    if(hasExists){
      FieldError fieldError = new FieldError("user", "name", user.getName(), false, null, null, "Duplicate name");
      bindingResult.addError(fieldError);
      return "user/new_user_form";
    }

    User newUser = new User(user.getName(), user.getPassword(), user.getRoleType());

    this.UserLogic.addUsers(newUser);

    this.userService.addUser(newUser.getName(), newUser.getPasswordEncrypted(), newUser.getRoleType().toString());

    return "redirect:/users";
  }

  @RequestMapping("/user/edit/{id}")
  public ModelAndView showEditFormUser(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("user/edit_user_form");
    User user = this.UserLogic.getUser(id);
    if (user == null) {
      user = new User();
    }

    user.setPassword(null);
    
    mav.addObject("user", user);
    return mav;
  }

  
  @RequestMapping(value = "/user/update", method = RequestMethod.POST)
  public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
    
    if(bindingResult.hasErrors()){
      return "user/edit_user_form";
    }
    
    FieldError fieldError = this.UserLogic.updateUser(user);

    if(fieldError != null)
    {
      bindingResult.addError(fieldError);
      return "user/edit_user_form";
    }

    this.userService.updateUser(user.getName(), user.getPasswordEncrypted(), user.getRoleType().toString());

    return "redirect:/users";
  }

  @RequestMapping("/user/delete/{id}")
  public String deleteUser(@PathVariable(name = "id") int id) {
   this.UserLogic.deleteUser(id);
   return "redirect:/users";
  }
  
}

