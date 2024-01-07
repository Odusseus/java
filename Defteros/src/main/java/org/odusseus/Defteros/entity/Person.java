package org.odusseus.Defteros.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Person extends BaseEntity{
	private Integer rating;

	public Person(String name, Integer rating) {
		super();
		this.name = name;
		this.rating = rating;
	}		
}
