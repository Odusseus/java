package org.odusseus.pinakas.Implementation;

import org.odusseus.pinakas.Interface.PlayerInterface;

import com.google.inject.Provider;

public class PlayerProvider implements Provider<PlayerInterface> {
		
	public PlayerInterface get() {
		PlayerInterface player = new Player();
		return player;		
	}

}
