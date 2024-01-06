package org.odusseus.Defteros.entity;

public class BaseEntity {
	protected Integer id;	
	protected String name;

	public BaseEntity() {
		super();
	}

	public BaseEntity(String name) {
		super();
		this.name = name;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
		return;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
