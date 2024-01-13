package org.odusseus.Defteros.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Person extends BaseEntity{
	@Positive(message = "Rating must be positif.")
	@NotNull(message = "Rating can not be empty.")
	private Integer rating;

	public Person(String name, Integer rating) {
		super();
		this.name = name;
		this.rating = rating;
	}		
}
