package org.odusseus.Defteros;

import java.util.List;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventBusiness {

	@Autowired
	private EventDAO eventDAO;
	
  @Autowired
	private EventsDAO eventsDAO;
	
	// public EventBusiness(){
	// 	super();
	// }

	public List<Event> getEventList() {
		//List<Event> listEvent = new ArrayList<>();
		//String date = "2023-01-01";//LocalDate.of(2024,01,01);
		//listEvent.add(new Event("Hot-Spirit", date));


		//@Autowired EventDAO eventDAO = new EventDAO();

		List<Event> listEvent = this.eventDAO.read();
		
		return listEvent;
	}

	public void add(Event event) {
		List<Event> listEvent = this.getEventList();
		listEvent.add(event);
		//EventDAO eventDAO = new EventDAO();
		
		this.eventDAO.save(listEvent);
	}
	
	public Events getEvents() {
		
		Events events = this.eventsDAO.read();
		
		return events;
	}
}
