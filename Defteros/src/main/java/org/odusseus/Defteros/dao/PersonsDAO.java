package org.odusseus.Defteros.dao;

import org.odusseus.Defteros.entity.Person;
import org.odusseus.Defteros.entity.Persons;

public class PersonsDAO extends EntitiesDAO<Person, Persons>{

	public PersonsDAO(){
		super(Persons.class);
	}
}
