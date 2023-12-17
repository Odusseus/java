package org.odusseus.prota;

import java.sql.Date;

public class User {
	private String name;
	private String note;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", note=" + note  
				+ "]";
	}

	
}