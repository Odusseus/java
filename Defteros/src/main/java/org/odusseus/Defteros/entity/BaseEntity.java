package org.odusseus.Defteros.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BaseEntity {
	protected Integer id;	

	@NotBlank(message = "Name cannot be empty.")
	protected String name;

	public BaseEntity(String name) {
		super();
		this.name = name;
	}
}
