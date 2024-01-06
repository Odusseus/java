package org.odusseus.Defteros.entity;

public class Event extends BaseEntity{
	private String dateLocal;

	public Event() {
		super();
	}

	public Event(String name, String dateLocal) {
		super();
		this.name = name;
		this.dateLocal = dateLocal;
	}		
	
	public String getDateLocal() {
		return dateLocal;
	}

	public void setDateLocal(String dateLocal) {
		this.dateLocal = dateLocal;
	}

}
