package org.odusseus.Defteros;

import java.time.*;;

public class Event {
	private Integer number;
	private String name;
	private LocalDate date;

	public Event() {
		super();
	}

	public Event(Integer number, String name, LocalDate date) {
		super();
		this.number = number;
		this.name = name;
		this.date = date;
	}
	
		public Integer getNumber() {
			return number;
		}
	
		public void setNumber(Integer number) {
			this.number = number;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
