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
	
	@Override
	public List<PlayerInterface> getPlayers() {
		return this.list;		
	}
	
	@Override
	public List<Integer> getListOfNumber(){
		List<Integer> returnList = new ArrayList<Integer>();
		Iterable<PlayerInterface> iterable = this.list;
		
		for (PlayerInterface player : iterable) {
		   returnList.add(player.getNumber());
		}
		
		return returnList;
		
		
	}
	
}
