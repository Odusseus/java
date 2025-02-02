package org.odusseus.Defteros.logic;

import org.odusseus.Defteros.entity.Users;
import org.odusseus.Defteros.utils.Utils;
import org.odusseus.Defteros.dao.UsersDAO;
import org.odusseus.Defteros.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class UserLogic {

  @Autowired
  private UsersDAO UsersDAO;

  public Users getUsers() {		
    Users users = this.UsersDAO.read();
    return users;
  }

  public void addUsers(User user) {
    this.UsersDAO.saveEntity(user);
  }

  public User getUser(Integer id) {		
    Users users = this.UsersDAO.read();
  
    for (User user : users.getList()) {
      if (user.getId() == id){
        return user;
      }
    }    
    return null;
  }	

  public void deleteUser(Integer id) {
    this.UsersDAO.delete(id);
    return;
  }

  public FieldError updateUser(User user) {
    if(getUsers().hasExistsIgnoreCase(user.getId(), user.getName()))
    {
      FieldError fieldError = new FieldError("user", "name", user.getName(), false, null, null, "Duplicate name");
      return fieldError;
    }

    user.setPasswordEncrypted(Utils.getBCryptPassword(user.getPassword()));
    user.setPassword(user.getPassword().replaceAll(".", "*"));
    	
    this.UsersDAO.updateEntity(user);
    return null;
  }

}
