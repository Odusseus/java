package org.odusseus.Defteros.entity;

public class Event extends BaseEntity{
	private String date;

	public Event() {
		super();
	}

	public Event(String name, String date) {
		super();
		this.date = date;
	}	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
