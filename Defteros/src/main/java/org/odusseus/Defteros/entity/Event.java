package org.odusseus.Defteros.entity;

public class Event {
	private Integer number;	
	private String name;
	private String date;

	public Event() {
		super();
	}

	public Event(String name, String date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
		return;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
