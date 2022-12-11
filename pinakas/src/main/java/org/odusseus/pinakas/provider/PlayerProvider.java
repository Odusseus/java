package org.odusseus.pinakas.provider;

import org.odusseus.pinakas.Implementation.Player;
import org.odusseus.pinakas.Interface.PlayerInterface;

import com.google.inject.Provider;

public class PlayerProvider implements Provider<PlayerInterface> {
		
	public PlayerInterface get() {
		PlayerInterface player = new Player();
		return player;		
	}

}
