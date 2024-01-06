package org.odusseus.Defteros.entity;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.Defteros.utils.Utils;

public class Persons {
  private Integer maxId = 0;
  private List<Person> list = new ArrayList<Person>();
  private String filename = Utils.getShortClassName(this)+".json";

  public Persons() {
    super();
  }
  
  public List<Person> getList() {
      return this.list;
  }

  public void add(Person person) {		
    this.maxId ++;
    person.setId(this.maxId);
    this.list.add(person);
  }

  public void delete(Integer id){

    List<Person> newList = new ArrayList<Person>();
    for (Person person
 : this.list) {
      if(person
.getId() != id){
        newList.add(person
);
      }
    } 
    this.list = newList;
  }

  public void update(Person
 newPerson
){

    Integer index = 0;
    List<Person> personList = this.getList();

    for (Person person : personList) {
      if(person.getId() == newPerson.getId()){
        break;
      }
      index ++;
    } 

    personList.set(index, newPerson);
  }

  public Integer getMaxId(){
    return this.maxId;
  }

  public String getFilename(){
    return this.filename;
  }
  
}
