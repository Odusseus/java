package org.odusseus.Defteros.controller;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.EventForm;
import org.odusseus.Defteros.entity.Events;
import org.odusseus.Defteros.logic.EventLogic;

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
public class AppController {

  @Autowired
  EventLogic eventLogic = new EventLogic();  

  @Autowired
  PersonLogic personLogic = new PersonLogic();  

  @RequestMapping("/")
    public String welcome() {
        System.out.println("Going home...");
        return "index";
    }    

  @RequestMapping("/events")
  public String events(Model model) {
    
    Events events = this.eventLogic.getEvents();
    
    model.addAttribute("events", events);		
    
    return "event/events";
  }

  @RequestMapping("/event/new")
  public String newEvent(Model model) {
    
    EventForm eventForm = new EventForm();		
    model.addAttribute("eventForm", eventForm);		
    
    return "event/new_event_form";
  }

  @RequestMapping("/event/save")
  public String saveEvent(@Valid EventForm eventForm, BindingResult bindingResult) {

    if(bindingResult.hasErrors()){
      return "event/new_event_form";
    }

    Event newEvent = new Event(eventForm.getId(), eventForm.getName(), eventForm.getDateLocal(), eventForm.getRounds());

    this.eventLogic.addEvents(newEvent);
    return "redirect:/events";
  }

  @RequestMapping("/event/edit/{id}")
  public ModelAndView showEditFormEvent(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("event/edit_event_form");
    Event event = this.eventLogic.getEvent(id);
    EventForm eventForm = null;
    if (event == null) {
      eventForm = new EventForm();
      } else {
        eventForm = new EventForm(event.getId(), event.getName(), event.getDateLocal(), event.getRounds());
      }    
    mav.addObject("eventForm", eventForm);
    return mav;
  }
  
  @RequestMapping(value = "/event/update", method = RequestMethod.POST)
  public String updateEvent(@Valid @ModelAttribute("eventForm") EventForm eventForm, BindingResult bindingResult) {
    if(bindingResult.hasErrors()){
      return "event/edit_event_form";
    }
    
    Event event = new Event(eventForm.getId(), eventForm.getName(), eventForm.getDateLocal(), eventForm.getRounds());
    this.eventLogic.updateEvent(event);
    return "redirect:/events";
  }

  @RequestMapping("/event/delete/{id}")
  public String deleteEvent(@PathVariable(name = "id") int id) {
   this.eventLogic.deleteEvent(id);
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
  public String savePerson(@Valid @ModelAttribute("Person") Person person, BindingResult bindingResult) {

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
}

