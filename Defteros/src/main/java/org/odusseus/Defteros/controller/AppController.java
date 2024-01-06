package org.odusseus.Defteros.controller;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.Events;
import org.odusseus.Defteros.logic.EventBusiness;

import org.odusseus.Defteros.entity.Person;
import org.odusseus.Defteros.entity.Persons;
import org.odusseus.Defteros.logic.PersonLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

  @Autowired
  EventBusiness business = new EventBusiness();  

  @Autowired
  PersonLogic personLogic = new PersonLogic();  

  @RequestMapping("/")
    public String welcome() {
        System.out.println("Going home...");
        return "index";
    }    

  @RequestMapping("/events")
  public String events(Model model) {
    
    Events events = this.business.getEvents();
    
    model.addAttribute("events", events);		
    
    return "event/events";
  }

  @RequestMapping("/event/new")
  public String newEvent(Model model) {
    
    Event event = new Event();		
    model.addAttribute("event", event);		
    
    return "event/new_event_form";
  }

  @RequestMapping("/event/save")
  public String saveEvent(Event event) {

    Event newEvent = new Event(event.getName(), event.getDateLocal());

    this.business.addEvents(newEvent);
    return "redirect:/events";
  }

  @RequestMapping("/event/edit/{id}")
  public ModelAndView showEditFormEvent(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("event/edit_form_event");
    Event event = this.business.getEvent(id);
    if (event == null) {
      event = new Event();    }
    
    mav.addObject("event", event);
    return mav;
  }

   @RequestMapping("/event/delete/{id}")
  public String deleteEvent(@PathVariable(name = "id") int id) {
    this.business.deleteEvent(id);
    return "redirect:/events";
  }

  @RequestMapping(value = "/event/update", method = RequestMethod.POST)
  public String updateEvent(@ModelAttribute("event") Event event) {
    
        this.business.updateEvent(event);
    return "redirect:/events";
  }

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
  public String savePerson(Person person) {

    Person newPerson = new Person(person.getName(), person.getRating());

    this.personLogic.addPersons(newPerson);
    return "redirect:/persons";
  }

  @RequestMapping("/person/edit/{id}")
  public ModelAndView showEditFormPerson(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("person/edit_form_person");
    Person person = this.personLogic.getPerson(id);
    if (person == null) {
      person = new Person();    }
    
    mav.addObject("person", person);
    return mav;
  }

   @RequestMapping("/person/delete/{id}")
  public String deletePerson(@PathVariable(name = "id") int id) {
    this.personLogic.deletePerson(id);
    return "redirect:/persons";
  }

  @RequestMapping(value = "/person/update", method = RequestMethod.POST)
  public String updatePerson(@ModelAttribute("person") Person person) {
    
        this.personLogic.updatePerson(person);
    return "redirect:/persons";
  }
}
