package org.odusseus.pinakas;

import java.util.List;

public interface PlayersInterface {

	void Add(String name);
	
	List<PlayerInterface> getPlayers();

	List<Integer> getListOfNumber();

}