package org.odusseus.Defteros.entity;

import java.util.ArrayList;
import java.util.List;

import org.odusseus.Defteros.utils.Utils;

public class BaseEntities<T extends BaseEntity> {
  protected Integer maxId = 0;
  protected List<T> list = new ArrayList<T>();
  protected String filename = Utils.getShortClassName(this)+".json";

  public BaseEntities() {
    super();
  }
  
  public List<T> 
  getList() {
      return this.list;
  }

  public void add(T baseEntity) {		
    this.maxId ++;
    baseEntity.setId(this.maxId);
    this.list.add(baseEntity);
  }

  public void delete(Integer id){

    List<T> newList = new ArrayList<T>();
    for (T baseEntity : this.list) {
      if(baseEntity.getId() != id){
        newList.add(baseEntity);
      }
    } 
    this.list = newList;
  }

  public void update(T newBaseEntity){

    Integer index = 0;
    List<T> baseEntityList = this.getList();

    for (T baseEntity : baseEntityList) {
      if(baseEntity.getId() == newBaseEntity.getId()){
        break;
      }
      index ++;
    } 

    baseEntityList.set(index, newBaseEntity);
  }

  public Integer getMaxId(){
    return this.maxId;
  }

  public String getFilename(){
    return this.filename;
  }  
}
