package org.odusseus.Defteros.entity;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.Defteros.Utils;

public class BaseEntities {
  private Integer maxId = 0;
  private List<Event> list = new ArrayList<Event>();
  private String filename = Utils.getShortClassName(this)+".json";

  public BaseEntities() {
    super();
  }
  
  public List<Event> getList() {
      return this.list;
  }

  public void add(Event event) {		
    this.maxId ++;
    event.setId(this.maxId);
    this.list.add(event);
  }

  public void delete(Integer id){

    List<Event> newList = new ArrayList<Event>();
    for (Event event : this.list) {
      if(event.getId() != id){
        newList.add(event);
      }
    } 
    this.list = newList;
  }

  public void update(Event newEvent){

    Integer index = 0;
    List<Event> eventList = this.getList();

    for (Event event : eventList) {
      if(event.getId() == newEvent.getId()){
        break;
      }
      index ++;
    } 

    eventList.set(index, newEvent);
  }

  public Integer getMaxId(){
    return this.maxId;
  }

  public String getFilename(){
    return this.filename;
  }
  
}
