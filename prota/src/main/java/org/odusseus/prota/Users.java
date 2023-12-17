package org.odusseus.prota;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Users {
	private List<User> list = new ArrayList<User>();

	public List<User> getUsers() {
		return this.list;
	}

	public void addName(User user) {
		this.list.add(user);
	}
	
}