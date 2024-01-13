package org.odusseus.Defteros.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class EventForm extends BaseEntityForm{
	
	  @NotNull(message = "Date cannot be empty.")
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private Date dateLocal;

		@NotNull(message = "Round cannot be empty.")
		@Min(2)
		@Max(99)
    private Integer rounds;


	public EventForm(Integer id, String name, Date dateLocal, Integer rounds) {
		super();
		this.id = id;
		this.name = name;
		this.dateLocal = dateLocal;		
		this.rounds = rounds;
	}		
}
