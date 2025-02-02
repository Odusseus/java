package org.odusseus.Defteros.logic;

import org.odusseus.Defteros.entity.Users;
import org.odusseus.Defteros.utils.Utils;
import org.odusseus.Defteros.dao.UsersDAO;
import org.odusseus.Defteros.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

  public void updateUser(User user) {
    user.setPasswordEncrypted(Utils.getBCryptPassword(user.getPassword()));
    user.setPassword(user.getPassword().replaceAll(".", "*"));	
    this.UsersDAO.updateEntity(user);
    return;
  }

}
