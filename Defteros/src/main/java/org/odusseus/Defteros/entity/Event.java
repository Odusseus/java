package org.odusseus.Defteros.entity;

public class Event {
	private Integer id;	
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
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
