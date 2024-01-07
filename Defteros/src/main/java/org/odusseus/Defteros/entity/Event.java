package org.odusseus.Defteros.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Event extends BaseEntity{
		private String dateLocal;
    private Integer rounds;


	public Event(String name, String dateLocal, Integer rounds) {
		super();
		this.name = name;
		this.dateLocal = dateLocal;		
		this.rounds = rounds;
	}		
}
