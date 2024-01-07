package org.odusseus.Defteros.logic;

import org.odusseus.Defteros.entity.Events;
import org.odusseus.Defteros.dao.EventsDAO;
import org.odusseus.Defteros.entity.Event;
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
    this.eventsDAO.saveEntity(event);
  }

  public Event getEvent(Integer id) {		
    Events events = this.eventsDAO.read();
  
    for (Event event : events.getList()) {
      if (event.getId() == id){
        return event;
      }
    }
    
    return null;
  }	

  public void deleteEvent(Integer id) {
    this.eventsDAO.delete(id);
    return;
  }

  public void updateEvent(Event event) {
    this.eventsDAO.updateEntity(event);
    return;
  }
}
