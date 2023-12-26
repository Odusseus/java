package org.odusseus.Defteros;

import java.util.List;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

  @Autowired
  EventBusiness business = new EventBusiness();
  

  @RequestMapping("/")
    public String welcome() {
        System.out.println("Going home...");
        return "index";
    }    

  @RequestMapping("/list_contact")
  public String listContact(Model model) {
    
    ContactBusiness business = new ContactBusiness();
    List<Contact> contactList = business.getContactList();
    
    model.addAttribute("contacts", contactList);		
    
    return "contact";
  }

  @RequestMapping("/list_event")
  public String listEvent(Model model) {
    
    //EventBusiness business = new EventBusiness();
    List<Event> eventList = this.business.getEventList();
    
    model.addAttribute("events", eventList);		
    
    return "event";
  }

  @RequestMapping("/new_event")
  public String newEvent(Model model) {
    
    Event event = new Event();		
    model.addAttribute("event", event);		
    
    return "new_event_form";
  }

  @RequestMapping("/save_event")
  public String saveEvent(Event event) {

    Event newEvent = new Event(event.getName(), event.getDate());
    
    //EventBusiness business = new EventBusiness();
    this.business.add(newEvent);
    return "redirect:/list_event";
  }

  //https://www.codejava.net/frameworks/spring-boot/spring-boot-crud-web-application-with-jdbc-thymeleaf-oracle

  @RequestMapping("/events")
  public String events(Model model) {
    
    //EventBusiness business = new EventBusiness();
    Events events = this.business.getEvents();
    
    model.addAttribute("events", events);		
    
    return "events";
  }
}
