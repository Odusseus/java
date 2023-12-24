package org.odusseus.Defteros;

import java.time.*;;

public class Event {
	private static Integer maxNumber = 0;
	private Integer number;	
	private String name;
	private String date;

	public Event() {
		super();
	}

	public Event(String name, String date) {
		super();
		maxNumber++;
		this.number = maxNumber;
		this.name = name;
		this.date = date;
	}
	
		public Integer getNumber() {
			return number;
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
