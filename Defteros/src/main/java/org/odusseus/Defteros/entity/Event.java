package org.odusseus.Defteros.entity;

public class Event{
	private Integer id;	
	private String name;
	private String dateLocal;

	public Event() {
		super();
	}

	public Event(String name, String dateLocal) {
		super();
		this.name = name;
		this.dateLocal = dateLocal;
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
		return dateLocal;
	}

	public void setDate(String dateLocal) {
		this.dateLocal = dateLocal;
	}



}
