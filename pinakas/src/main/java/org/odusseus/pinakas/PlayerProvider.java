package org.odusseus.pinakas;

import com.google.inject.Provider;

public class PlayerProvider implements Provider<PlayerInterface> {
		
	public PlayerInterface get() {
		PlayerInterface player = new Player();
		return player;		
	}

}
