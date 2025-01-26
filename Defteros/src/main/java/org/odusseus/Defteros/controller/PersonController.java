package org.odusseus.Defteros.controller;

import org.odusseus.Defteros.entity.Person;
import org.odusseus.Defteros.entity.Persons;
import org.odusseus.Defteros.logic.PersonLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class PersonController {

  @Autowired
  PersonLogic personLogic = new PersonLogic();  

  @RequestMapping("/persons")
  public String persons(Model model) {
    
    Persons persons = this.personLogic.getPersons();
    
    model.addAttribute("persons", persons);		
    
    return "person/persons";
  }

  @RequestMapping("/person/new")
  public String newPerson(Model model) {
    
    Person person = new Person();		
    model.addAttribute("person", person);		
    
    return "person/new_person_form";
  }

  @RequestMapping("/person/save")
  public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {

    if(bindingResult.hasErrors()){
      return "person/new_person_form";
    }

    Person newPerson = new Person(person.getName(), person.getRating());

    this.personLogic.addPersons(newPerson);
    return "redirect:/persons";
  }

  @RequestMapping("/person/edit/{id}")
  public ModelAndView showEditFormPerson(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("person/edit_person_form");
    Person person = this.personLogic.getPerson(id);
    if (person == null) {
      person = new Person();    }
    
    mav.addObject("person", person);
    return mav;
  }

  
  @RequestMapping(value = "/person/update", method = RequestMethod.POST)
  public String updatePerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
    
    if(bindingResult.hasErrors()){
      return "person/edit_person_form";
    }
    
    this.personLogic.updatePerson(person);
    return "redirect:/persons";
  }

  @RequestMapping("/person/delete/{id}")
  public String deletePerson(@PathVariable(name = "id") int id) {
   this.personLogic.deletePerson(id);
   return "redirect:/persons";
  }

  // @RequestMapping("/event/content")
  // public String requestMethodName(Model model) {
  //     return "/event/events :: content";
  // }

  
  // public ThymeleafView viewBean(){
  //   ThymeleafView view = new ThymeleafView("/event/events");
  //   view.setMarkupSelector("content");
  //   return view; 
  // }
  
}

