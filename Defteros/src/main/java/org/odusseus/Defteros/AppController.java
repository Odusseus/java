package org.odusseus.Defteros;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

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
		
		EventBusiness business = new EventBusiness();
		List<Event> eventList = business.getEventList();
		
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
		
		EventBusiness business = new EventBusiness();
		business.add(event);
		return "redirect:/list_event";
	}

	//https://www.codejava.net/frameworks/spring-boot/spring-boot-crud-web-application-with-jdbc-thymeleaf-oracle
}
