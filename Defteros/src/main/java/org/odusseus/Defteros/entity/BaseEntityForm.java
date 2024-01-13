package org.odusseus.Defteros.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BaseEntityForm {
	protected Integer id;	

	@NotBlank(message = "Name cannot be empty.")
	protected String name;

	public BaseEntityForm(String name) {
		super();
		this.name = name;
	}
}
