package org.odusseus.Defteros.entity;

public class Person extends BaseEntity{
	private Integer rating;

	public Person() {
		super();
	}

	public Person(String name, Integer rating) {
		super();
		this.name = name;
		this.rating = rating;
	}		
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
