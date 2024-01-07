package org.odusseus.Defteros.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Event extends BaseEntity{
	private String dateLocal;

	public Event(String name, String dateLocal) {
		super();
		this.name = name;
		this.dateLocal = dateLocal;
	}		
}
