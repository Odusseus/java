package org.odusseus.pinakas;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Players implements PlayersInterface  {
	
	List<PlayerInterface> list;
	private Provider<PlayerInterface> playerProvider;
	
    @Inject
    public Players(
    		Provider<PlayerInterface> playerProvider
    		)
	{
		this.list = new  ArrayList<PlayerInterface>();	
		this.playerProvider = playerProvider;
	}
	
	@Override
	public void Add(String name)
	{
		PlayerInterface player = this.playerProvider.get();
		player.setName(name);
		player.setNumber(this.list.size() + 1);
				
		list.add(player);
	}
	
	public List<PlayerInterface> getPlayers() {
		return this.list;		
	}

}
