package org.odusseus.Defteros;

import java.util.ArrayList;
import java.util.List;
import java.time.*;


public class EventBusiness {
	public List<Event> getEventList() {
		List<Event> listEvent = new ArrayList<>();
		LocalDate date = LocalDate.of(2024,01,01);
		listEvent.add(new Event(1, "Hot-Spirit", date));
		
		return listEvent;
	}
}
