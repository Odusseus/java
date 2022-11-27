package org.odusseus.pinakas;

import com.google.inject.Inject;

public class PlayerBuilder implements PlayerBuilderInterface {
	
	private PlayerInterface player;

	@Inject
	public PlayerBuilder(PlayerInterface player) {
		this.player = player;
	}
	
	@Override
	public PlayerInterface Create(int number, String name) {
		this.player.setNumber(number);
		this.player.setName(name);
		return this.player;		
	}
}
