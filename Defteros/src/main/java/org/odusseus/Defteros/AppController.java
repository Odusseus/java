package org.odusseus.Defteros;

import java.util.List;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.Events;
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

  
  @RequestMapping("/events")
  public String events(Model model) {
    
    Events events = this.business.getEvents();
    
    model.addAttribute("events", events);		
    
    return "events";
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

    this.business.addEvents(newEvent);
    return "redirect:/events";
  }

  @RequestMapping("/edit/{id}")
  public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
    ModelAndView mav = new ModelAndView("edit_form_event");
    Event event = this.business.getEvent(id);
    if (event == null) {
      event = new Event();    }
    
    mav.addObject("event", event);
    return mav;
  }

   @RequestMapping("/delete/{id}")
  public String deleteEvent(@PathVariable(name = "id") int id) {
    this.business.deleteEvent(id);
    return "redirect:/events";
  }

  @RequestMapping(value = "/update_event", method = RequestMethod.POST)
  public String updateEvent(@ModelAttribute("event") Event event) {
    
        this.business.updateEvent(event);
    return "redirect:/events";
  }
}

