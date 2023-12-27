package org.odusseus.Defteros;

import java.util.List;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.Events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventBusiness {

  @Autowired
	private EventsDAO eventsDAO;

	public Events getEvents() {		
		Events events = this.eventsDAO.read();		
		return events;
	}

	public void addEvents(Event event) {
		this.eventsDAO.saveEvent(event);
	}
	
}
