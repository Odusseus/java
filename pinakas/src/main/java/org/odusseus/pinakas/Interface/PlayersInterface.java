package org.odusseus.pinakas.Interface;

import java.util.List;

public interface PlayersInterface {

	void Add(String name);
	
	int getFieldLenght();

	List<Integer> getListOfNumber();

	List<PlayerInterface> getPlayers();
	    
    int size();
}