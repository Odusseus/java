package org.odusseus.pinakas;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

public class Players implements PlayersInterface  {
	
	List<PlayerInterface> list;
    PlayerBuilderInterface playerBuilder;	
	
    @Inject
    public Players(PlayerBuilderInterface playerBuilder)
	{
		this.list = new  ArrayList<PlayerInterface>();	
		this.playerBuilder = playerBuilder;
	}
	
	@Override
	public void Add(String name)
	{
		PlayerInterface player = this.playerBuilder.Create(this.list.size() + 1, name);
		list.add(player);
	}
	
	public List<PlayerInterface> getPlayers() {
		return this.list;		
	}

}
