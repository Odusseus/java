package org.odusseus.Defteros;

import java.util.ArrayList;
import java.util.List;
import java.time.*;


public class EventBusiness {
	public List<Event> getEventList() {
		//List<Event> listEvent = new ArrayList<>();
		//String date = "2023-01-01";//LocalDate.of(2024,01,01);
		//listEvent.add(new Event("Hot-Spirit", date));

		EventDAO eventDAO = new EventDAO();

		List<Event> listEvent = eventDAO.read();
		
		return listEvent;
	}

	public void add(Event event) {
		List<Event> listEvent = this.getEventList();
		listEvent.add(event);
		EventDAO eventDAO = new EventDAO();
		eventDAO.save(listEvent);
	}
}
