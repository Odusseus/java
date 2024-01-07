package org.odusseus.Defteros.dao;

import org.odusseus.Defteros.entity.Event;
import org.odusseus.Defteros.entity.Events;


public class EventsDAO extends EntitiesDAO<Event, Events> {
		public EventsDAO(){
		super(Events.class);
	}
}
