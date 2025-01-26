package org.odusseus.Defteros.dao;

import org.odusseus.Defteros.entity.User;
import org.odusseus.Defteros.entity.Users;

public class UsersDAO extends EntitiesDAO<User, Users>{

	public UsersDAO(){
		super(Users.class);
	}
}
