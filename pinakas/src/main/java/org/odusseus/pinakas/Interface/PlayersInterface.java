package org.odusseus.pinakas.Interface;

import java.util.List;

public interface PlayersInterface {

	void Add(String name);
	
	List<PlayerInterface> getPlayers();

	List<Integer> getListOfNumber();
	
    int getFieldLenght();

}