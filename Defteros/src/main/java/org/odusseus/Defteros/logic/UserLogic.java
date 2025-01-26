package org.odusseus.Defteros.logic;

import org.odusseus.Defteros.entity.Users;
import org.odusseus.Defteros.dao.UsersDAO;
import org.odusseus.Defteros.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLogic {

  @Autowired
  private UsersDAO UsersDAO;

  public Users getUsers() {		
    Users Users = this.UsersDAO.read();
    return Users;
  }

  public void addUsers(User User) {
    this.UsersDAO.saveEntity(User);
  }

  public User getUser(Integer id) {		
    Users Users = this.UsersDAO.read();
  
    for (User User : Users.getList()) {
      if (User.getId() == id){
        return User;
      }
    }
    
    return null;
  }	

  public void deleteUser(Integer id) {
    this.UsersDAO.delete(id);
    return;
  }

  public void updateUser(User User) {
    this.UsersDAO.updateEntity(User);
    return;
  }

}
