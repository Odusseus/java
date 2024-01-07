package org.odusseus.Defteros.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BaseEntity {
	protected Integer id;	
	protected String name;

	public BaseEntity(String name) {
		super();
		this.name = name;
	}
}
