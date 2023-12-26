package org.odusseus.Defteros.entity;

import java.util.ArrayList;
import java.util.List;

public class Events {
	private Integer maxNumber = 0;
	private List<Event> list = new ArrayList<Event>();

	public Events() {
		super();
	}
	
	public List<Event> getList() {
			return this.list;
	}

	public void add(Event event) {		
		this.list.add(event);
		this.maxNumber ++;
	}
}
