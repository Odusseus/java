package org.odusseus.Defteros.logic;

import org.odusseus.Defteros.entity.Persons;
import org.odusseus.Defteros.dao.PersonsDAO;
import org.odusseus.Defteros.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonLogic {

  @Autowired
  private PersonsDAO personsDAO;

  public Persons getPersons() {		
    Persons persons = this.personsDAO.read();
    return persons;
  }

  public void addPersons(Person person) {
    this.personsDAO.savePerson(person);
  }

  public Person getPerson(Integer id) {		
    Persons persons = this.personsDAO.read();
  
    for (Person person : persons.getList()) {
      if (person.getId() == id){
        return person;
      }
    }
    
    return null;
  }	

  public void deletePerson(Integer id) {
    this.personsDAO.delete(id);
    return;
  }

  public void updatePerson(Person person) {
    this.personsDAO.updatePerson(person);
    return;
  }

}
